package com.wsinz.login.presentation

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginView {

    private val presenter: LoginPresenter<LoginView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setBackground()
        setListenersForButtons()
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
        login_background.alpha = 0.2f
        Glide.with(this)
                .load(R.drawable.office_background)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(40)))
                .into(login_background)
    }

    private fun setListenersForButtons() {
        login_button.setOnClickListener {
            presenter.loginUser(username_input.text.toString(), password_input.text.toString())
        }
        register_user.setOnClickListener { presenter.openRegisterUserForm() }
        register_company.setOnClickListener { presenter.openRegisterCompanyForm() }
    }

    override fun showLoginButtonProgress() {
        login_button.text = ""
        login_button_progress.visibility = View.VISIBLE
    }

    override fun hideLoginButtonProgress() {
        login_button.text = this.getText(R.string.login_button)
        login_button_progress.visibility = View.GONE
    }
}