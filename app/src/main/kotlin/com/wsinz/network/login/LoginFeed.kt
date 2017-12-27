package com.wsinz.network.login

import com.wsinz.network.base.BaseService
import com.wsinz.network.login.model.LoginBody
import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.Single
import okhttp3.OkHttpClient

class LoginFeed(okHttpClient: OkHttpClient) : BaseService<LoginRetrofitApi>(okHttpClient), LoginFeedApi {

    override fun login(loginBody: LoginBody): Single<LoginResponse> =
            restAdapter(endpoint = "login").login(loginBody)

    override fun getGenericParameter(): Class<LoginRetrofitApi> =
            LoginRetrofitApi::class.java
}