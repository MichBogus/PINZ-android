package com.wsinz.register.registeruser.presentation

interface RegisterUserView {

    fun showRegisterButtonProgress()
    fun hideRegisterButtonProgress()
    fun showRegisterSuccessDialog(onDismissAction: () -> Unit)
    fun showRegisterErrorDialog(reason: String = "", onDismissAction: () -> Unit)
    fun returnToMainScreen()

    fun showPasswordError()
    fun hidePasswordError()
}