package com.wsinz.network.register

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.BaseService
import com.wsinz.network.register.model.RegisterUserBody
import io.reactivex.Single
import okhttp3.OkHttpClient

class RegisterUserFeed(okHttpClient: OkHttpClient) : BaseService<RegisterRetrofitApi>(okHttpClient), RegisterUserFeedApi {

    override fun getGenericParameter(): Class<RegisterRetrofitApi> = RegisterRetrofitApi::class.java

    override fun registerUser(body: RegisterUserBody) : Single<BaseResponse> =
            restAdapter(endpoint = "register").registerUser(body)
}