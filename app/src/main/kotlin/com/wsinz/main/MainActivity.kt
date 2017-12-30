package com.wsinz.main

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.base.util.PermissionProvider.Companion.CAMERA_PERMISSION_CODE
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MainView {

    private val presenter: MainPresenter<MainView> by inject()

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBackground()
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    private fun setBackground() {
        main_background.alpha = 0.2f
        Glide.with(this)
                .load(R.drawable.office_background)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(40)))
                .into(main_background)
    }

    private fun setListeners() {
        log_out_button.setOnClickListener { presenter.logout() }
        my_items_button.setOnClickListener { presenter.itemsList() }
        scan_item_button.setOnClickListener { presenter.scanNewItems() }
    }

    override fun closeActivity() {
        finish()
    }

    override fun showPermissionDialog(permission: String) {
        ActivityCompat.requestPermissions(this, arrayOf(permission), CAMERA_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            CAMERA_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.scanNewItems()
                }
            }
        }
    }
}