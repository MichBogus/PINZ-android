package com.wsinz.register.registeruser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.register.registeruser.presentation.RegisterUserPresenter
import com.wsinz.register.registeruser.presentation.RegisterUserView
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_register_company.*
import org.koin.android.ext.android.inject

class RegisterUserActivity : BaseActivity(), RegisterUserView {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegisterUserActivity::class.java)
    }

    val presenter: RegisterUserPresenter<RegisterUserView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        setBackground()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    private fun setBackground() {
        register_background.alpha = 0.2f
        Glide.with(this)
                .load(R.drawable.office_background)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(40)))
                .into(register_background)
    }
}