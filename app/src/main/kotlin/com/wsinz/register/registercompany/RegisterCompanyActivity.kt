package com.wsinz.register.registercompany

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.register.registercompany.presentation.RegisterCompanyPresenter
import com.wsinz.register.registercompany.presentation.RegisterCompanyView
import org.koin.android.ext.android.inject

class RegisterCompanyActivity: BaseActivity(), RegisterCompanyView {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegisterCompanyActivity::class.java)
    }

    val presenter: RegisterCompanyPresenter<RegisterCompanyView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_company)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}