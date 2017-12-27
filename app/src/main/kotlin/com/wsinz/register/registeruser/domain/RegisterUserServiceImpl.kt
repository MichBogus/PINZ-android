package com.wsinz.register.registeruser.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.RegisterUserFeedApi
import com.wsinz.network.register.model.RegisterUserBody
import io.reactivex.Single

class RegisterUserServiceImpl(private val registerUserFeedApi: RegisterUserFeedApi) : RegisterUserService {

    override fun registerUser(body: RegisterUserBody): Single<BaseResponse> =
            registerUserFeedApi.registerUser(body)
}