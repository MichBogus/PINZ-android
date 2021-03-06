package com.wsinz.di

import com.wsinz.login.domain.LoginService
import com.wsinz.login.domain.LoginServiceImpl
import com.wsinz.myitems.domain.ItemsService
import com.wsinz.myitems.domain.ItemsServiceApi
import com.wsinz.network.items.AddItemFeed
import com.wsinz.network.items.AddItemFeedApi
import com.wsinz.network.items.ItemsListFeed
import com.wsinz.network.items.ItemsListFeedApi
import com.wsinz.network.login.LoginFeed
import com.wsinz.network.login.LoginFeedApi
import com.wsinz.network.register.RegisterCompanyFeed
import com.wsinz.network.register.RegisterCompanyFeedApi
import com.wsinz.network.register.RegisterUserFeed
import com.wsinz.network.register.RegisterUserFeedApi
import com.wsinz.register.registercompany.domain.RegisterCompanyService
import com.wsinz.register.registercompany.domain.RegisterCompanyServiceImpl
import com.wsinz.register.registeruser.domain.RegisterUserService
import com.wsinz.register.registeruser.domain.RegisterUserServiceImpl
import com.wsinz.scanitem.domain.AddItemService
import com.wsinz.scanitem.domain.AddItemServiceImpl
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class NetworkConnectionModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "NetworkConnection") {
            provide { LoginFeed(get()) } bind LoginFeedApi::class
            provide { LoginServiceImpl(get()) } bind LoginService::class

            provide { RegisterCompanyFeed(get()) } bind RegisterCompanyFeedApi::class
            provide { RegisterUserFeed(get()) } bind RegisterUserFeedApi::class
            provide { RegisterCompanyServiceImpl(get()) } bind RegisterCompanyService::class
            provide { RegisterUserServiceImpl(get()) } bind RegisterUserService::class

            provide { ItemsListFeed(get()) } bind ItemsListFeedApi::class
            provide { ItemsService(get(), get()) } bind ItemsServiceApi::class
            provide { AddItemFeed(get()) } bind AddItemFeedApi::class
            provide { AddItemServiceImpl(get(), get()) } bind AddItemService::class
        }
    }
}