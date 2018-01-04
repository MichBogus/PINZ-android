package com.wsinz.myitems.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.myitems.adapter.ItemDataHolder
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_my_items.*
import org.koin.android.ext.android.inject

class MyItemsActivity : BaseActivity(), MyItemsView {

    companion object {
        fun createIntent(context: Context) = Intent(context, MyItemsActivity::class.java)
    }

    val presenter: MyItemsPresenter<MyItemsView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_items)
        setBackground()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        presenter.detach()
        super.onPause()
    }

    private fun setBackground() {
        items_background.alpha = 0.2f
        Glide.with(this)
                .load(R.drawable.office_background)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(40)))
                .into(items_background)
    }

    override fun displayItems(items: List<ItemDataHolder>) {

    }
}