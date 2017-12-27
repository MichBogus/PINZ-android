package com.wsinz.register.registeruser.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.model.RegisterUserBody
import io.reactivex.Single

interface RegisterUserService {

    fun registerUser(body: RegisterUserBody): Single<BaseResponse>
}