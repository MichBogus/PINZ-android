package com.wsinz.coredomain

class UserCoreImpl : UserCore {

    private var authToken: String = ""

    override fun authToken() = authToken

    override fun saveAuthToken(authToken: String) {
        this.authToken = authToken
    }
}