package com.wsinz.network.items

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.BaseService
import com.wsinz.network.items.model.AddItemBody
import io.reactivex.Single
import okhttp3.OkHttpClient

class AddItemFeed(okHttpClient: OkHttpClient) : BaseService<ItemsRetrofitApi>(okHttpClient), AddItemFeedApi {

    override fun getGenericParameter(): Class<ItemsRetrofitApi> = ItemsRetrofitApi::class.java

    override fun addItem(authToken: String, body: AddItemBody): Single<BaseResponse> =
            restAdapter(endpoint = "item").addItem(authToken, body)
}