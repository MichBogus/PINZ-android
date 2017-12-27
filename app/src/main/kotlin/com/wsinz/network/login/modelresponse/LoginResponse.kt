package com.wsinz.network.login.modelresponse

import com.google.gson.annotations.SerializedName
import com.wsinz.network.base.BaseResponse

class LoginResponse(@SerializedName("authToken") val authToken: String,
                    status: String,
                    wsCode: String,
                    wsCodeValue: String,
                    reason: String,
                    ok: Boolean) : BaseResponse(status, wsCode, wsCodeValue, reason, ok)