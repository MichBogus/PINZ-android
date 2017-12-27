package com.wsinz.network.login

import com.wsinz.network.login.model.LoginBody
import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.Single

interface LoginFeedApi {

    fun login(loginBody: LoginBody): Single<LoginResponse>
}