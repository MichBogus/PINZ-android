package com.wsinz.network.register

import com.wsinz.network.base.BaseService
import com.wsinz.network.login.LoginRetrofitApi
import okhttp3.OkHttpClient

class RegisterCompanyFeed(okHttpClient: OkHttpClient): BaseService<RegisterRetrofitApi>(okHttpClient), RegisterCompanyFeedApi {

    override fun getGenericParameter(): Class<RegisterRetrofitApi> = RegisterRetrofitApi::class.java
}