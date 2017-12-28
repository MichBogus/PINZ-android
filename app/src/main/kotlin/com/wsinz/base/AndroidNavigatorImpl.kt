package com.wsinz.base

import android.content.Context
import com.wsinz.login.presentation.LoginActivity
import com.wsinz.main.MainActivity
import com.wsinz.register.registercompany.presentation.RegisterCompanyActivity
import com.wsinz.register.registeruser.RegisterUserActivity
import com.wsinz.scanitem.ScanItemsActivity

class AndroidNavigatorImpl(private val context: Context) : AndroidNavigator {

    override fun openLoginActivity() {
        context.startActivity(LoginActivity.createIntent(context))
    }

    override fun openRegisterUser() {
        context.startActivity(RegisterUserActivity.createIntent(context))
    }

    override fun openRegisterCompany() {
        context.startActivity(RegisterCompanyActivity.createIntent(context))
    }

    override fun openMainActivity() {
        context.startActivity(MainActivity.createIntent(context))
    }

    override fun openScanItemsActivity() {
        context.startActivity(ScanItemsActivity.createIntent(context))
    }
}