package com.wsinz.network.register

import com.wsinz.network.base.BaseService
import com.wsinz.network.register.model.RegisterCompanyBody
import com.wsinz.network.register.modelresponse.RegisterCompanyResponse
import io.reactivex.Single
import okhttp3.OkHttpClient

class RegisterCompanyFeed(okHttpClient: OkHttpClient) : BaseService<RegisterRetrofitApi>(okHttpClient), RegisterCompanyFeedApi {

    override fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<RegisterCompanyResponse> =
            restAdapter(endpoint = "register").registerCompany(registerCompanyBody)

    override fun getGenericParameter(): Class<RegisterRetrofitApi> = RegisterRetrofitApi::class.java
}