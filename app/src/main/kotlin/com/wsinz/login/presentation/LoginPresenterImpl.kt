package com.wsinz.login.presentation

import com.wsinz.login.domain.LoginService

class LoginPresenterImpl(val loginService: LoginService) : LoginPresenter<LoginView> {

    var view: LoginView? = null

    override fun attach(view: LoginView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}