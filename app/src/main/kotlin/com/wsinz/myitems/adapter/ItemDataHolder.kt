package com.wsinz.myitems.adapter

import com.google.gson.annotations.SerializedName

class ItemDataHolder(@SerializedName("name") val name: String,
                     @SerializedName("description") val description: String,
                     @SerializedName("dateOfAddition") val dateOfAddition: String,
                     @SerializedName("companyCode") val companyCode: String,
                     @SerializedName("itemToken") val itemToken: String) {

    var onDeleteClickAction: (itemToken: String) -> Unit = {}
}