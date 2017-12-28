package com.wsinz.scanitem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import com.wsinz.R
import com.wsinz.base.BaseActivity
import kotlinx.android.synthetic.main.activity_scan_item.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScanItemsActivity : BaseActivity(), ZXingScannerView.ResultHandler {

    companion object {
        fun createIntent(context: Context) = Intent(context, ScanItemsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_item)
    }

    override fun onResume() {
        super.onResume()
        scanner.setResultHandler(this) // Register ourselves as a handler for scan results.
        scanner.startCamera()          // Start camera on resume
    }

    override fun onPause() {
        super.onPause()
        scanner.stopCamera()           // Stop camera on pause
    }

    override fun handleResult(rawResult: Result) {
        // Do something with the result here
        Log.v("SCAN", rawResult.text) // Prints scan results
        Log.v("SCAN", rawResult.barcodeFormat.toString()) // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        scanner.resumeCameraPreview(this)
    }
}