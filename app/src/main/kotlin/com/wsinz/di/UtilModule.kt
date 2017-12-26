package com.wsinz.di

import com.wsinz.base.util.StringProvider
import com.wsinz.base.util.StringProviderImpl
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class UtilModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "Utils") {
            provide {
                StringProviderImpl(get())
            } bind StringProvider::class
        }
    }
}