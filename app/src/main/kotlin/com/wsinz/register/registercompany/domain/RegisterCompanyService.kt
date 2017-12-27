package com.wsinz.register.registercompany.domain

import com.wsinz.network.register.model.RegisterCompanyBody
import com.wsinz.network.register.modelresponse.RegisterCompanyResponse
import io.reactivex.Single

interface RegisterCompanyService {

    fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<RegisterCompanyResponse>
}