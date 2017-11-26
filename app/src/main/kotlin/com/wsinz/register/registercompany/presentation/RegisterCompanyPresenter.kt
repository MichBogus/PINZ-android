package com.wsinz.register.registercompany.presentation

interface RegisterCompanyPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()
}