package com.wsinz.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.wsinz.base.BaseActivity

class MainActivity : BaseActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}