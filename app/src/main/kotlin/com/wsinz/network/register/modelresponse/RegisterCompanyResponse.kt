package com.wsinz.network.register.modelresponse

import com.google.gson.annotations.SerializedName
import com.wsinz.network.base.BaseResponse

class RegisterCompanyResponse(@SerializedName("companyCode") val companyCode: String,
                              status: String,
                              wsCode: String,
                              wsCodeValue: String,
                              reason: String,
                              ok: Boolean) : BaseResponse(status, wsCode, wsCodeValue, reason, ok)