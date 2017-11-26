package com.wsinz.register.registeruser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.register.registeruser.presentation.RegisterUserPresenter
import com.wsinz.register.registeruser.presentation.RegisterUserView
import org.koin.android.ext.android.inject

class RegisterUserActivity : BaseActivity(), RegisterUserView {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegisterUserActivity::class.java)
    }

    val presenter: RegisterUserPresenter<RegisterUserView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
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