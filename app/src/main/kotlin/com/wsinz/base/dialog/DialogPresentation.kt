package com.wsinz.base.dialog

import android.content.Context

interface DialogPresentation {

    fun showSuccessDialog(context: Context, title: String, message: String, onDismissAction: () -> Unit)
    fun showErrorDialog(context: Context, title: String, message: String, onDismissAction: () -> Unit)
    fun showProgressDialog(context: Context, message: String)
    fun hideProgressDialog(context: Context)
}