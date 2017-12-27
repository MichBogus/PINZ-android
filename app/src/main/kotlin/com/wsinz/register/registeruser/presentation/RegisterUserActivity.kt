package com.wsinz.register.registeruser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.base.dialog.DialogPresentation
import com.wsinz.network.register.model.RegisterUserBody
import com.wsinz.register.registeruser.presentation.RegisterUserPresenter
import com.wsinz.register.registeruser.presentation.RegisterUserView
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_register_user.*
import org.koin.android.ext.android.inject

class RegisterUserActivity : BaseActivity(), RegisterUserView {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegisterUserActivity::class.java)
    }

    val presenter: RegisterUserPresenter<RegisterUserView> by inject()
    val dialogs: DialogPresentation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        setBackground()
        setListeners()
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

    private fun setListeners() {
        register_button.setOnClickListener {
            presenter.register(RegisterUserBody(username = username_input.text.toString(),
                    password = password_input.text.toString(),
                    companyCode = company_code_input.text.toString(),
                    userName = name_input.text.toString(),
                    userLastName = last_name_input.text.toString()))
        }

        password_input.addTextChangedListener(PasswordTextWatcher {
            presenter.validatePassword(password_input.text.toString(),
                    password_confirm_input.text.toString())
        })

        password_confirm_input.addTextChangedListener(PasswordTextWatcher {
            presenter.validatePassword(password_input.text.toString(),
                    password_confirm_input.text.toString())
        })
    }

    override fun showPasswordError() {
        password_input.error = getString(R.string.register_user_password_confirmation_error)
        password_confirm_input.error = getString(R.string.register_user_password_confirmation_error)
    }

    override fun hidePasswordError() {
        password_input.error = null
        password_confirm_input.error = null
    }

    override fun showRegisterButtonProgress() {
        register_button_progress.visibility = View.VISIBLE
        register_button.text = ""
    }

    override fun hideRegisterButtonProgress() {
        register_button_progress.visibility = View.GONE
        register_button.text = this.getString(R.string.register_button)
    }

    override fun showRegisterSuccessDialog(onDismissAction: () -> Unit) {
        dialogs.showSuccessDialog(this,
                this.getString(R.string.register_user_success_title),
                this.getString(R.string.register_user_success_message),
                onDismissAction)
    }

    override fun showRegisterErrorDialog(reason: String, onDismissAction: () -> Unit) {
        val errorMessage = if (reason.isEmpty()) {
            getString(R.string.dialog_connection_problem)
        } else {
            reason
        }

        dialogs.showErrorDialog(this,
                this.getString(R.string.register_user_error_title),
                errorMessage,
                onDismissAction)
    }

    override fun returnToMainScreen() {
        onBackPressed()
    }

    private class PasswordTextWatcher(private val textChangedAction: () -> Unit) : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textChangedAction.invoke()
        }
    }
}