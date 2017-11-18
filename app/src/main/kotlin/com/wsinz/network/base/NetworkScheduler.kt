package com.wsinz.network.base

import io.reactivex.Single
import io.reactivex.functions.Consumer

interface NetworkScheduler {

    fun <T> schedule(single: Single<T>, onSuccess: Consumer<T>, onFail: Consumer<Throwable>)

    fun disposeAll()
}