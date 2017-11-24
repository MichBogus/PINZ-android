package com.wsinz.network.base

import com.google.gson.annotations.SerializedName

data class BaseResponse(@SerializedName("status") val status: String,
                        @SerializedName("wsCode") val wsCode: String,
                        @SerializedName("wsCodeValue") val wsCodeValue: String,
                        @SerializedName("reason") val reason: String,
                        @SerializedName("ok") val ok: Boolean)