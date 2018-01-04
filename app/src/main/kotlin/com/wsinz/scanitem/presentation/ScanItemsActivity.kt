package com.wsinz.scanitem.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.zxing.Result
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.base.dialog.DialogPresentation
import kotlinx.android.synthetic.main.activity_scan_item.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.koin.android.ext.android.inject

class ScanItemsActivity : BaseActivity(), ZXingScannerView.ResultHandler, ScanView {

    companion object {
        fun createIntent(context: Context) = Intent(context, ScanItemsActivity::class.java)
    }

    private val presenter: ScanPresenter<ScanView> by inject()
    private val dialogs: DialogPresentation by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_item)
    }

    override fun onResume() {
        super.onResume()
        startCamera()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        stopCamera()
        presenter.detach()
    }

    override fun handleResult(rawResult: Result) {
        stopCamera()
        presenter.addScannedItem(rawResult.text)
    }

    override fun stopCamera() {
        scanner.stopCamera()
    }

    override fun startCamera() {
        scanner.setResultHandler(this)
        scanner.startCamera()
    }

    override fun resumeCamera() {
        scanner.resumeCameraPreview(this)
    }

    override fun showItemScannedError() {
        dialogs.showErrorDialog(this,
                getString(R.string.scan_item_error_title),
                getString(R.string.scan_item_wrong_qr_message),
                {})
    }

    override fun hideProgressDialog() {
        dialogs.hideProgressDialog(this)
    }

    override fun showProgressDialog() {
        dialogs.showProgressDialog(this, getString(R.string.dialog_progress))
    }

    override fun showSuccessDialog() {
        dialogs.showSuccessDialog(this,
                getString(R.string.scan_item_success_title),
                getString(R.string.scan_item_success_message),
                { startCamera() })
    }

    override fun showErrorDialog(reason: String, dismissDialogAction: () -> Unit) {
        val errorMessage = if (reason.isEmpty()) {
            getString(R.string.dialog_connection_problem)
        } else {
            reason
        }

        dialogs.showErrorDialog(this,
                this.getString(R.string.scan_item_error_title),
                errorMessage,
                dismissDialogAction)
    }
}