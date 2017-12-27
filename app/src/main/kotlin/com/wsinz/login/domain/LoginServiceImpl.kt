package com.wsinz.login.domain

import com.wsinz.network.base.withErrorHandling
import com.wsinz.network.login.LoginFeedApi
import com.wsinz.network.login.model.LoginBody
import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.Single

class LoginServiceImpl(val loginServiceFeedApi: LoginFeedApi) : LoginService {

    override fun loginUser(username: String, password: String): Single<LoginResponse> =
            loginServiceFeedApi.login(LoginBody(username, password))
                    .withErrorHandling()
}