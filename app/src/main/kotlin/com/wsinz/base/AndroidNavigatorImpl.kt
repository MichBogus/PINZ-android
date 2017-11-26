package com.wsinz.base

import android.content.Context
import com.wsinz.register.registercompany.presentation.RegisterCompanyActivity
import com.wsinz.register.registeruser.RegisterUserActivity

class AndroidNavigatorImpl(private val context: Context) : AndroidNavigator {

    override fun openRegisterUser() {
        context.startActivity(RegisterUserActivity.createIntent(context))
    }

    override fun openRegisterCompany() {
        context.startActivity(RegisterCompanyActivity.createIntent(context))
    }
}