package com.wsinz.network.items

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single

interface ItemsListFeedApi {

    fun getUserItems(authToken: String): Single<UserItemsResponse>

    fun deleteItem(authToken: String, itemToken: String): Single<BaseResponse>
}