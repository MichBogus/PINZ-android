package com.wsinz.register.registeruser.presentation

interface RegisterUserPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()
}