package com.wsinz.login.presentation

interface LoginView {

    fun showLoginButtonProgress()
    fun hideLoginButtonProgress()
    fun showErrorDialog(reason: String = "", onDismissAction: () -> Unit)
    fun loginUser()
}