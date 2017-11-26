package com.wsinz.register.registeruser.presentation

class RegisterUserPresenterImpl() : RegisterUserPresenter<RegisterUserView> {

    var view: RegisterUserView? = null

    override fun attach(view: RegisterUserView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}