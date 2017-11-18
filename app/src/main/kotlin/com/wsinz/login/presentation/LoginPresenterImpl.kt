package com.wsinz.login.presentation

import com.wsinz.base.AndroidNavigator
import com.wsinz.login.domain.LoginService
import com.wsinz.network.base.NetworkScheduler
import io.reactivex.functions.Consumer

class LoginPresenterImpl(private val androidNavigator: AndroidNavigator,
                         private val loginService: LoginService,
                         private val networkScheduler: NetworkScheduler) : LoginPresenter<LoginView> {

    var view: LoginView? = null

    override fun attach(view: LoginView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun loginUser(userName: String, password: String) {
        view?.showLoginButtonProgress()
        networkScheduler.schedule(loginService.loginUser(userName, password),
                                  Consumer { onSuccessLogin() },
                                  Consumer { onFailLogin(it) })
    }

    private fun onSuccessLogin() {
        view?.hideLoginButtonProgress()
    }

    private fun onFailLogin(throwable: Throwable) {
        view?.hideLoginButtonProgress()
    }

    override fun openRegisterUserForm() {
        androidNavigator.openRegisterUser()
    }

    override fun openRegisterCompanyForm() {
        androidNavigator.openRegisterCompany()
    }
}