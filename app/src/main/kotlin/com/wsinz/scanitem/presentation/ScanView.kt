package com.wsinz.scanitem.presentation

interface ScanView {

    fun stopCamera()
    fun startCamera()
    fun resumeCamera()
    fun showProgressDialog()
    fun hideProgressDialog()
    fun showSuccessDialog()
    fun showErrorDialog(reason: String = "", dismissDialogAction: () -> Unit)
    fun showItemScannedError()
}