package com.wsinz.base.dialog

import android.app.Dialog
import android.content.Context
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog
import com.wsinz.R
import com.wsinz.base.util.StringProvider

class DialogPresentationImpl(private val stringProvider: StringProvider) : DialogPresentation {

    private var currentDialog: Dialog? = null

    override fun showSuccessDialog(context: Context, title: String, message: String, onDismissAction: () -> Unit) {
        hidePreviousDialog()

        currentDialog = AwesomeSuccessDialog(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setDoneButtonText(stringProvider.getString(R.string.dialog_ok_button))
                .setDoneButtonClick { currentDialog?.hide() }
                .show()

        currentDialog?.setOnDismissListener { onDismissAction.invoke() }
    }

    override fun showErrorDialog(context: Context, title: String, message: String, onDismissAction: () -> Unit) {
        hidePreviousDialog()

        currentDialog = AwesomeErrorDialog(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setButtonText(stringProvider.getString(R.string.dialog_ok_button))
                .setErrorButtonClick { currentDialog?.hide() }
                .show()

        currentDialog?.setOnDismissListener { onDismissAction.invoke() }
    }

    private fun hidePreviousDialog() {
        currentDialog?.let {
            currentDialog?.hide()
        }
    }
}