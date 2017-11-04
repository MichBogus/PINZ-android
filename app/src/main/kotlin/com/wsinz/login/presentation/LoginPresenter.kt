package com.wsinz.login.presentation

interface LoginPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()
}