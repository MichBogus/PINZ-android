package com.wsinz.register.registercompany.presentation

class RegisterCompanyPresenterImpl : RegisterCompanyPresenter<RegisterCompanyView> {

    var view: RegisterCompanyView? = null

    override fun attach(view: RegisterCompanyView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}