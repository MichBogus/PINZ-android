package com.wsinz.network.login

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.BaseService
import com.wsinz.network.login.model.LoginBody
import io.reactivex.Single
import okhttp3.OkHttpClient

class LoginFeed(okHttpClient: OkHttpClient) : BaseService<LoginRetrofitApi>(okHttpClient), LoginFeedApi {

    override fun login(loginBody: LoginBody): Single<BaseResponse> =
            restAdapter(endpoint = "login/").login(loginBody)

    override fun getGenericParameter(): Class<LoginRetrofitApi> =
            LoginRetrofitApi::class.java
}