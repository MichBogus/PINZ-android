package com.wsinz.network.register.model

import com.google.gson.annotations.SerializedName

data class CompanyAddress(@SerializedName("street") val street: String,
                          @SerializedName("streetNumber") val streetNumber: String,
                          @SerializedName("city") val city: String)