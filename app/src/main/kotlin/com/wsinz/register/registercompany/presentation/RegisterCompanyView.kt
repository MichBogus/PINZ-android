package com.wsinz.register.registercompany.presentation

interface RegisterCompanyView {

    fun showRegisterButtonProgress()
    fun hideRegisterButtonProgress()
    fun showRegisterSuccessDialog(onDismissAction: () -> Unit)
    fun showRegisterErrorDialog(reason: String = "", onDismissAction: () -> Unit)
    fun returnToMainScreen()
}