package com.wsinz.login.presentation

import android.os.Bundle
import com.wsinz.R
import com.wsinz.base.BaseActivity
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginView {

    private val loginPresenter: LoginPresenter<LoginView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        loginPresenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        loginPresenter.detach()
    }

}