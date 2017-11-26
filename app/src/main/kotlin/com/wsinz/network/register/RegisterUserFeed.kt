package com.wsinz.network.register

import com.wsinz.network.base.BaseService
import okhttp3.OkHttpClient

class RegisterUserFeed(okHttpClient: OkHttpClient) : BaseService<RegisterRetrofitApi>(okHttpClient), RegisterUserFeedApi {

    override fun getGenericParameter(): Class<RegisterRetrofitApi> = RegisterRetrofitApi::class.java
}