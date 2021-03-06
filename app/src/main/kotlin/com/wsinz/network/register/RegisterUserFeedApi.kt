package com.wsinz.network.register

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.model.RegisterUserBody
import io.reactivex.Single

interface RegisterUserFeedApi {

    fun registerUser(body: RegisterUserBody): Single<BaseResponse>
}