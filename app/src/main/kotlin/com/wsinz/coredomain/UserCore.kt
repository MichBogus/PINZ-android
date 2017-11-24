package com.wsinz.coredomain

interface UserCore {

    fun authToken(): String
    fun saveAuthToken(authToken: String)
}