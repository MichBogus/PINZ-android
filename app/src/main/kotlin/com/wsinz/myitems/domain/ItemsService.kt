package com.wsinz.myitems.domain

import com.wsinz.coredomain.UserCore
import com.wsinz.network.items.ItemsListFeedApi
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single

class ItemsService(private val itemsListFeedApi: ItemsListFeedApi,
                   private val userCore: UserCore) : ItemsServiceApi {

    override fun getUserItems(): Single<UserItemsResponse> =
            itemsListFeedApi.getUserItems(userCore.authToken())

}