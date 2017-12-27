package com.wsinz.register.registercompany.presentation

interface RegisterCompanyView {

    fun showButtonProgress()
    fun hideButtonProgress()
    fun showCompanySuccessDialog(companyCode: String, onDismissAction: () -> Unit)
    fun showErrorDialog(reason: String = "", onDismissAction: () -> Unit)
    fun returnToMainScreen()
}