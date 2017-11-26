package com.wsinz.network.register

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.BaseService
import com.wsinz.network.register.model.RegisterCompanyBody
import io.reactivex.Single
import okhttp3.OkHttpClient

class RegisterCompanyFeed(okHttpClient: OkHttpClient) : BaseService<RegisterRetrofitApi>(okHttpClient), RegisterCompanyFeedApi {

    override fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<BaseResponse> =
            restAdapter("register").registerCompany(registerCompanyBody)

    override fun getGenericParameter(): Class<RegisterRetrofitApi> = RegisterRetrofitApi::class.java
}