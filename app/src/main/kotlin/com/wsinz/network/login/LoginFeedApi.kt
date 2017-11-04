package com.wsinz.network.login

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.login.model.LoginBody
import io.reactivex.Single

interface LoginFeedApi {

    fun login(loginBody: LoginBody): Single<BaseResponse>
}