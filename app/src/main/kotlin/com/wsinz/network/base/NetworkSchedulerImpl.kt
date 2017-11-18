package com.wsinz.network.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

class NetworkSchedulerImpl(private val schedulerIO: Scheduler,
                           private val schedulerUI: Scheduler) : NetworkScheduler {

    private val composite: CompositeDisposable = CompositeDisposable()

    override fun <T> schedule(single: Single<T>, onSuccess: Consumer<T>, onFail: Consumer<Throwable>) {
        composite.add(single.subscribeOn(schedulerIO)
                              .observeOn(schedulerUI)
                              .subscribe(onSuccess, onFail))
    }

    override fun disposeAll() {
        composite.clear()
    }
}