package com.wsinz.di

import com.wsinz.login.presentation.LoginPresenter
import com.wsinz.login.presentation.LoginPresenterImpl
import com.wsinz.register.registercompany.presentation.RegisterCompanyPresenter
import com.wsinz.register.registercompany.presentation.RegisterCompanyPresenterImpl
import com.wsinz.register.registeruser.presentation.RegisterUserPresenter
import com.wsinz.register.registeruser.presentation.RegisterUserPresenterImpl
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context

class PresenterModule : AndroidModule() {

    override fun context(): Context = applicationContext {
        context(name = "Presenter") {
            provide {
                LoginPresenterImpl(get(), get(), get(), get())
            } bind LoginPresenter::class

            provide {
                RegisterCompanyPresenterImpl()
            } bind RegisterCompanyPresenter::class
            provide {
                RegisterUserPresenterImpl()
            } bind RegisterUserPresenter::class
        }
    }

}