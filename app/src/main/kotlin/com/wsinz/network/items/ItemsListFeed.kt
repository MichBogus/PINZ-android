package com.wsinz.network.items

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.BaseService
import com.wsinz.network.items.model.DeleteItemBody
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single
import okhttp3.OkHttpClient

class ItemsListFeed(okHttpClient: OkHttpClient) : BaseService<ItemsRetrofitApi>(okHttpClient), ItemsListFeedApi {

    override fun getGenericParameter(): Class<ItemsRetrofitApi> = ItemsRetrofitApi::class.java

    override fun getUserItems(authToken: String): Single<UserItemsResponse> =
            restAdapter(endpoint = "item").getUserItems(authToken)

    override fun deleteItem(authToken: String, itemToken: String): Single<BaseResponse> =
            restAdapter(endpoint = "item").deleteItem(authToken, DeleteItemBody(itemToken))
}