package com.wsinz.network.register.model

import com.google.gson.annotations.SerializedName

data class RegisterUserBody(@SerializedName("username") val username: String,
                            @SerializedName("password") val password: String,
                            @SerializedName("companyCode") val companyCode: String,
                            @SerializedName("name") val userName: String,
                            @SerializedName("lastName") val userLastName: String)