package com.wsinz.network.items

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.model.AddItemBody
import com.wsinz.network.items.model.DeleteItemBody
import com.wsinz.network.items.modelresponse.UserItemsResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ItemsRetrofitApi {

    @GET("getUserItems")
    fun getUserItems(@Header("AUTH_TOKEN") authToken: String): Single<UserItemsResponse>

    @POST("deleteItem")
    fun deleteItem(@Header("AUTH_TOKEN") authToken: String,
                   @Body deleteItemBody: DeleteItemBody): Single<BaseResponse>

    @POST("addItem")
    fun addItem(@Header("AUTH_TOKEN") authToken: String,
                @Body body: AddItemBody): Single<BaseResponse>
}