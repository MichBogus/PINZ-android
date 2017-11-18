package com.wsinz.login.presentation

interface LoginPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun loginUser(userName: String, password: String)
    fun openRegisterUserForm()
    fun openRegisterCompanyForm()
}