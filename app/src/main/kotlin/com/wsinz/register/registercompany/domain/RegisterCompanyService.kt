package com.wsinz.register.registercompany.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.model.RegisterCompanyBody
import io.reactivex.Single

interface RegisterCompanyService {

    fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<BaseResponse>
}