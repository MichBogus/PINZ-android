package com.wsinz.myitems.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single

interface ItemsServiceApi {

    fun getUserItems(): Single<UserItemsResponse>

    fun deleteItem(itemToken: String): Single<BaseResponse>
}