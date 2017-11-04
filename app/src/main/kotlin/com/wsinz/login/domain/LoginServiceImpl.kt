package com.wsinz.login.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.login.LoginFeedApi
import com.wsinz.network.login.model.LoginBody
import io.reactivex.Single

class LoginServiceImpl(val loginServiceFeedApi: LoginFeedApi) : LoginService {

    override fun loginUser(username: String, password: String): Single<BaseResponse> =
            loginServiceFeedApi.login(LoginBody(username, password))
}