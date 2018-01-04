package com.wsinz.myitems.presentation

import com.wsinz.myitems.domain.ItemsServiceApi
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.functions.Consumer

class MyItemsPresenterImpl(private val itemsServiceApi: ItemsServiceApi,
                           private val networkScheduler: NetworkScheduler,
                           private val itemsMapper: ItemsMapper) : MyItemsPresenter<MyItemsView> {

    var view: MyItemsView? = null

    override fun attach(view: MyItemsView) {
        this.view = view
        gatherUserItems()
    }

    override fun detach() {
        networkScheduler.disposeAll()
        view = null
    }

    override fun gatherUserItems() {
        networkScheduler.schedule(itemsServiceApi.getUserItems(),
                Consumer { onSuccessResponseForUserItems(it) },
                Consumer { onFailResponseForUserItems(it) })
    }

    private fun onSuccessResponseForUserItems(userItemsResponse: UserItemsResponse) {
        val itemsDataHolders = itemsMapper.map(userItemsResponse.items)
        itemsDataHolders.forEach {
            it.onDeleteClickAction = {

            }
        }
        view?.displayItems(itemsDataHolders)
    }

    private fun onFailResponseForUserItems(throwable: Throwable) {

    }
}