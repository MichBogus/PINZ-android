package com.wsinz.network.items.modelresponse

import com.google.gson.annotations.SerializedName
import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.model.Item

class UserItemsResponse(@SerializedName("items") val items: List<Item>,
                        status: String,
                        wsCode: String,
                        wsCodeValue: String,
                        reason: String,
                        ok: Boolean) : BaseResponse(status, wsCode, wsCodeValue, reason, ok) {
}