package com.wsinz.scanitem.domain

import com.wsinz.network.base.BaseResponse
import com.wsinz.network.items.model.AddItemBody
import io.reactivex.Single

interface AddItemService {

    fun addItem(body: AddItemBody): Single<BaseResponse>
}