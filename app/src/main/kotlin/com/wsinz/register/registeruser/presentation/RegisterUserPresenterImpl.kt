package com.wsinz.register.registeruser.presentation

import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.register.model.RegisterUserBody
import com.wsinz.register.registeruser.domain.RegisterUserService
import io.reactivex.functions.Consumer

class RegisterUserPresenterImpl(private val registerUserService: RegisterUserService,
                                private val networkScheduler: NetworkScheduler) : RegisterUserPresenter<RegisterUserView> {

    var view: RegisterUserView? = null

    override fun attach(view: RegisterUserView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun register(body: RegisterUserBody) {
        view?.showRegisterButtonProgress()
        networkScheduler.schedule(registerUserService.registerUser(body),
                Consumer { onSuccessRegister() },
                Consumer { onFailRegister(it) })
    }

    override fun validatePassword(password: String, passwordConfirmation: String) {
        if (password.isEmpty() || passwordConfirmation.isEmpty()) {
            view?.hidePasswordError()
            return
        }

        if (password == passwordConfirmation) {
            view?.hidePasswordError()
        } else {
            view?.showPasswordError()
        }
    }

    private fun onSuccessRegister() {
        view?.hideRegisterButtonProgress()
        view?.showRegisterSuccessDialog { view?.returnToMainScreen() }
    }

    private fun onFailRegister(throwable: Throwable) {
        view?.hideRegisterButtonProgress()

        if (throwable is AppWSErrorThrowable) {
            view?.showRegisterErrorDialog(throwable.error?.reason!!, {})
        } else {
            view?.showRegisterErrorDialog { }
        }
    }
}