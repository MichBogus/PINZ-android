package com.wsinz.di

import com.wsinz.login.domain.LoginService
import com.wsinz.login.domain.LoginServiceImpl
import com.wsinz.network.login.LoginFeed
import com.wsinz.network.login.LoginFeedApi
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class NetworkConnectionModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "NetworkConnection") {
            provide { LoginFeed(get()) } bind LoginFeedApi::class
            provide { LoginServiceImpl(get()) } bind LoginService::class
        }
    }
}