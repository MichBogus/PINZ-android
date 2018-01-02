package com.wsinz.network.items.model

import com.google.gson.annotations.SerializedName

data class DeleteItemBody(@SerializedName("itemToken") val itemToken: String)