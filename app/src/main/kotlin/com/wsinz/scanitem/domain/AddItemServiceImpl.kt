package com.wsinz.scanitem.domain

import com.wsinz.coredomain.UserCore
import com.wsinz.network.base.BaseResponse
import com.wsinz.network.base.withErrorHandling
import com.wsinz.network.items.AddItemFeedApi
import com.wsinz.network.items.model.AddItemBody
import io.reactivex.Single

class AddItemServiceImpl(private val addItemFeedApi: AddItemFeedApi,
                         private val userCore: UserCore) : AddItemService {

    override fun addItem(body: AddItemBody): Single<BaseResponse> =
            addItemFeedApi.addItem(userCore.authToken(), body)
                    .withErrorHandling()
}