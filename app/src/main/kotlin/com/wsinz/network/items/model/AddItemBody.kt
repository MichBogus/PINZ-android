package com.wsinz.network.items.model

import com.google.gson.annotations.SerializedName

class AddItemBody(@SerializedName("name") val name: String,
                  @SerializedName("description") val description: String,
                  @SerializedName("dateOfAddition") var dateOfAddition: String,
                  @SerializedName("itemToken") val itemToken: String) {

    fun isEmpty(): Boolean =
            name.isEmpty() || description.isEmpty() || itemToken.isEmpty()
}