package com.wsinz.register.registercompany.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.withErrorHandling
import com.wsinz.network.register.RegisterCompanyFeedApi
import com.wsinz.network.register.model.RegisterCompanyBody
import com.wsinz.network.register.modelresponse.RegisterCompanyResponse
import io.reactivex.Single

class RegisterCompanyServiceImpl(private val registerCompanyFeedApi: RegisterCompanyFeedApi) : RegisterCompanyService {

    override fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<RegisterCompanyResponse> =
            registerCompanyFeedApi.registerCompany(registerCompanyBody)
                    .withErrorHandling()
}