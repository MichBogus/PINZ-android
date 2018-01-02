package com.wsinz.scanitem.presentation

interface ScanView {

    fun stopCamera()
    fun startCamera()
    fun resumeCamera()
    fun openItemInformationDialog()
    fun addItemToAccount()
    fun showSuccessDialog()
    fun showErrorDialog()
}