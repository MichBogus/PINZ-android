package com.wsinz.register.registercompany.presentation

import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.register.model.CompanyAddress
import com.wsinz.network.register.model.RegisterCompanyBody
import com.wsinz.network.register.modelresponse.RegisterCompanyResponse
import com.wsinz.register.registercompany.domain.RegisterCompanyService
import io.reactivex.functions.Consumer

class RegisterCompanyPresenterImpl(private val registerCompanyService: RegisterCompanyService,
                                   private val networkScheduler: NetworkScheduler) : RegisterCompanyPresenter<RegisterCompanyView> {

    var view: RegisterCompanyView? = null

    override fun attach(view: RegisterCompanyView) {
        this.view = view
    }

    override fun detach() {
        networkScheduler.disposeAll()
        view = null
    }

    override fun registerCompany(companyName: String,
                                 companyNip: String,
                                 companyStreet: String,
                                 companyStreetNumber: String,
                                 companyCity: String) {
        view?.showButtonProgress()
        networkScheduler.schedule(registerCompanyService.registerCompany(RegisterCompanyBody(companyName,
                CompanyAddress(
                        companyStreet,
                        companyStreetNumber,
                        companyCity),
                companyNip)),
                Consumer { onRegisterSuccess(it) },
                Consumer { onRegisterFail(it) })
    }

    private fun onRegisterSuccess(response: RegisterCompanyResponse) {
        view?.hideButtonProgress()
        view?.showCompanySuccessDialog(response.companyCode, { view?.returnToMainScreen() })
    }

    private fun onRegisterFail(throwable: Throwable) {
        view?.hideButtonProgress()

        if (throwable is AppWSErrorThrowable) {
            view?.showErrorDialog(throwable.error?.reason!!, {})
        } else {
            view?.showErrorDialog { }
        }
    }
}