package com.wsinz.network.items

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.model.AddItemBody
import io.reactivex.Single

interface AddItemFeedApi {

    fun addItem(authToken: String, body: AddItemBody): Single<BaseResponse>
}