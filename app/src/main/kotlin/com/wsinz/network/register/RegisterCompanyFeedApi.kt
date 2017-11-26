package com.wsinz.network.register

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.register.model.RegisterCompanyBody
import io.reactivex.Single

interface RegisterCompanyFeedApi {

    fun registerCompany(registerCompanyBody: RegisterCompanyBody): Single<BaseResponse>
}