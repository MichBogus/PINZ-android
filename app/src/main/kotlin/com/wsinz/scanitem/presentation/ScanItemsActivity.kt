package com.wsinz.scanitem.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import com.wsinz.R
import com.wsinz.base.BaseActivity
import kotlinx.android.synthetic.main.activity_scan_item.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.koin.android.ext.android.inject

class ScanItemsActivity : BaseActivity(), ZXingScannerView.ResultHandler, ScanView {

    companion object {
        fun createIntent(context: Context) = Intent(context, ScanItemsActivity::class.java)
    }

    val presenter: ScanPresenter<ScanView> by inject()

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
        presenter.validateScannedData(rawResult.text)

        scanner.resumeCameraPreview(this)
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

    override fun openItemInformationDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addItemToAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccessDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}