package com.wsinz.myitems.domain

import com.wsinz.coredomain.UserCore
import com.wsinz.myitems.adapter.ItemDataHolder
import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.ItemsListFeedApi
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single

class ItemsService(private val itemsListFeedApi: ItemsListFeedApi,
                   private val userCore: UserCore) : ItemsServiceApi {

    override fun getUserItems(): Single<UserItemsResponse> =
            itemsListFeedApi.getUserItems(userCore.authToken())

    override fun deleteItem(itemToken: String): Single<BaseResponse> =
            itemsListFeedApi.deleteItem(userCore.authToken(), itemToken)

}