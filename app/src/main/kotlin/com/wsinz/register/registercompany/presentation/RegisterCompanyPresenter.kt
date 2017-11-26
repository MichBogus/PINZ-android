package com.wsinz.register.registercompany.presentation

interface RegisterCompanyPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun registerCompany(companyName: String,
                        companyNip: String,
                        companyStreet: String,
                        companyStreetNumber: String,
                        companyCity: String)
}