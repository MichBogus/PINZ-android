package com.wsinz.network.login

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.login.model.LoginBody
import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitApi {

    @POST("loginUser")
    fun login(@Body loginBody: LoginBody): Single<LoginResponse>
}