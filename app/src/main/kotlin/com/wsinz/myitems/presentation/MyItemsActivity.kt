package com.wsinz.myitems.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.wsinz.R
import com.wsinz.base.BaseActivity
import org.koin.android.ext.android.inject

class MyItemsActivity : BaseActivity(), MyItemsView {

    companion object {
        fun createIntent(context: Context) = Intent(context, MyItemsActivity::class.java)
    }

    val presenter: MyItemsPresenter<MyItemsView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_items)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }
}