package com.wsinz.register.registercompany.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wsinz.R
import com.wsinz.base.BaseActivity
import com.wsinz.base.dialog.DialogPresentation
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_register_company.*
import org.koin.android.ext.android.inject

class RegisterCompanyActivity : BaseActivity(), RegisterCompanyView {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegisterCompanyActivity::class.java)
    }

    val presenter: RegisterCompanyPresenter<RegisterCompanyView> by inject()
    val dialogs: DialogPresentation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_company)

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
            presenter.registerCompany(company_name_input.text.toString(),
                    company_nip_input.text.toString(),
                    company_address_street_input.text.toString(),
                    company_address_street_number_input.text.toString(),
                    company_address_city_input.text.toString())
        }
    }

    override fun showCompanySuccessDialog(companyCode: String, onDismissAction: () -> Unit) {
        dialogs.showSuccessDialog(this,
                this.getString(R.string.register_company_success_title),
                String.format(this.getString(R.string.register_company_success_message), companyCode),
                onDismissAction)
    }

    override fun showErrorDialog(reason: String, onDismissAction: () -> Unit) {
        val errorMessage = if (reason.isEmpty()) {
            getString(R.string.dialog_connection_problem)
        } else {
            reason
        }

        dialogs.showErrorDialog(this,
                this.getString(R.string.register_company_error_title),
                errorMessage,
                onDismissAction)
    }

    override fun hideButtonProgress() {
        register_button_progress.visibility = View.GONE
        register_button.text = this.getString(R.string.register_button)
    }

    override fun showButtonProgress() {
        register_button_progress.visibility = View.VISIBLE
        register_button.text = ""
    }

    override fun returnToMainScreen() {
        onBackPressed()
    }

}