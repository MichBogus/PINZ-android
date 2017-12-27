package com.wsinz.login.domain

import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.Single

interface LoginService {

    fun loginUser(username: String, password: String): Single<LoginResponse>
}