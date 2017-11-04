package com.wsinz.login.domain

import com.wsinz.network.base.BaseResponse
import io.reactivex.Single

interface LoginService {

    fun loginUser(username: String, password: String): Single<BaseResponse>
}