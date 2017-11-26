package com.wsinz.network.register.model

import com.google.gson.annotations.SerializedName

data class RegisterCompanyBody(@SerializedName("name") val companyName: String,
                               @SerializedName("address") val companyAddress: CompanyAddress,
                               @SerializedName("NIP") val companyNIP: String)