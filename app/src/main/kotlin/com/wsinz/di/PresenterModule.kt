package com.wsinz.di

import com.wsinz.login.presentation.LoginPresenter
import com.wsinz.login.presentation.LoginPresenterImpl
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class PresenterModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "Presenter") {
            provide {
                LoginPresenterImpl(get(), get(), get(), get())
            } bind LoginPresenter::class
        }
    }

}