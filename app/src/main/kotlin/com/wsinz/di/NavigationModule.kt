package com.wsinz.di

import com.wsinz.base.AndroidNavigator
import com.wsinz.base.AndroidNavigatorImpl
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class NavigationModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "Navigation") {
            provide { AndroidNavigatorImpl() } bind AndroidNavigator::class
        }
    }

}