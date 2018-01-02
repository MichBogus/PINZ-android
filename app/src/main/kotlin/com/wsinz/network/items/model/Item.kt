package com.wsinz.network.items.model

import com.google.gson.annotations.SerializedName

data class Item(@SerializedName("id") val itemId: Long,
                @SerializedName("userSignedToItemId") val userId: Long,
                @SerializedName("name") val name: String,
                @SerializedName("description") val description: String,
                @SerializedName("dateOfAddition") val dateOfAddition: String,
                @SerializedName("companyCode") val companyCode: String,
                @SerializedName("itemToken") val itemToken: String)