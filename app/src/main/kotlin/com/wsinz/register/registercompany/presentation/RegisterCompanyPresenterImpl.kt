package com.wsinz.register.registercompany.presentation

import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.register.model.CompanyAddress
import com.wsinz.network.register.model.RegisterCompanyBody
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
        view?.showRegisterButtonProgress()
        networkScheduler.schedule(registerCompanyService.registerCompany(RegisterCompanyBody(companyName,
                CompanyAddress(
                        companyStreet,
                        companyStreetNumber,
                        companyCity),
                companyNip)),
                Consumer { onRegisterSuccess() },
                Consumer { onRegisterFail(it) })
    }

    private fun onRegisterSuccess() {
        view?.hideRegisterButtonProgress()
        view?.showRegisterSuccessDialog { view?.returnToMainScreen() }
    }

    private fun onRegisterFail(throwable: Throwable) {
        view?.hideRegisterButtonProgress()

        if (throwable is AppWSErrorThrowable) {
            view?.showRegisterErrorDialog(throwable.error?.reason!!, {})
        }
    }
}