package com.wsinz.myitems.presentation

import com.wsinz.myitems.domain.ItemsServiceApi
import com.wsinz.network.base.AppWSErrorThrowable
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
        view?.showProgressBar()
        networkScheduler.schedule(itemsServiceApi.getUserItems(),
                Consumer { onSuccessResponseForUserItems(it) },
                Consumer { onFailResponseForUserItems(it) })
    }

    private fun onSuccessResponseForUserItems(userItemsResponse: UserItemsResponse) {
        view?.hideProgressBar()
        val itemsDataHolders = itemsMapper.map(userItemsResponse.items)
        itemsDataHolders.forEach {
            it.onDeleteClickAction = {
                deleteItem(it)
            }
        }
        view?.displayItems(itemsDataHolders)
    }

    private fun onFailResponseForUserItems(throwable: Throwable) {
        view?.hideProgressBar()

        if (throwable is AppWSErrorThrowable) {
            view?.showErrorDialog(throwable.error?.reason!!, { })
        } else {
            view?.showErrorDialog { }
        }
    }

    override fun deleteItem(itemToken: String) {
        view?.showProgressBar()
        networkScheduler.schedule(itemsServiceApi.deleteItem(itemToken),
                Consumer { gatherUserItems() },
                Consumer { onFailResponseForUserItems(it) })
    }
}