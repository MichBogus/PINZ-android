package com.wsinz.network.register

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.model.RegisterCompanyBody
import com.wsinz.network.register.model.RegisterUserBody
import com.wsinz.network.register.modelresponse.RegisterCompanyResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterRetrofitApi {

    @POST("registerCompany")
    fun registerCompany(@Body registerCompanyBody: RegisterCompanyBody): Single<RegisterCompanyResponse>

    @POST("registerUser")
    fun registerUser(@Body registerUserBody: RegisterUserBody): Single<BaseResponse>
}