package com.wsinz.login.presentation

import android.os.Bundle
import android.os.PersistableBundle
import com.wsinz.R
import com.wsinz.base.BaseActivity
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginView {

    private val loginPresenter: LoginPresenter<LoginView> by inject()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
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