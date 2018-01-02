package com.wsinz.network.items

import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single

interface ItemsListFeedApi {

    fun getUserItems(authToken: String): Single<UserItemsResponse>
}