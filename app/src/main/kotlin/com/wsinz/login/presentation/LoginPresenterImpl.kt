package com.wsinz.login.presentation

import com.wsinz.base.AndroidNavigator
import com.wsinz.coredomain.UserCore
import com.wsinz.login.domain.LoginService
import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.login.modelresponse.LoginResponse
import io.reactivex.functions.Consumer

class LoginPresenterImpl(private val androidNavigator: AndroidNavigator,
                         private val loginService: LoginService,
                         private val networkScheduler: NetworkScheduler,
                         private val userCore: UserCore) : LoginPresenter<LoginView> {

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
                Consumer { onSuccessLogin(it) },
                Consumer { onFailLogin(it) })
    }

    private fun onSuccessLogin(loginResponse: LoginResponse) {
        view?.hideLoginButtonProgress()
        userCore.saveAuthToken(loginResponse.authToken)
        androidNavigator.openMainActivity()
        view?.closeActivity()
    }

    private fun onFailLogin(throwable: Throwable) {
        view?.hideLoginButtonProgress()

        if (throwable is AppWSErrorThrowable) {
            view?.showErrorDialog(throwable.error?.reason!!, {})
        } else {
            view?.showErrorDialog {}
        }
    }

    override fun openRegisterUserForm() {
        androidNavigator.openRegisterUser()
    }

    override fun openRegisterCompanyForm() {
        androidNavigator.openRegisterCompany()
    }
}