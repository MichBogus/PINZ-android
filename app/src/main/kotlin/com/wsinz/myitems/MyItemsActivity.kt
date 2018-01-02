package com.wsinz.myitems

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.wsinz.R
import com.wsinz.base.BaseActivity

class MyItemsActivity : BaseActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MyItemsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_items)
    }
}