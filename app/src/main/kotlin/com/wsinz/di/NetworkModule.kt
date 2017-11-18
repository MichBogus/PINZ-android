package com.wsinz.di

import com.wsinz.BuildConfig
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.base.NetworkSchedulerImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context
import java.util.concurrent.TimeUnit

class NetworkModule : AndroidModule() {

    companion object {
        val SCHEDULERIO_NAME = "SchedulerIO"
        val SCHEDULERUI_NAME = "SchedulerUI"
    }

    private val CONNECTION_TIMEOUT_IN_SECONDS = 30L
    private val SOCKET_READ_TIMEOUT_IN_SECONDS = 30L

    override fun context(): Context = applicationContext {
        context(name = "Network") {
            provide { provideOkHttpClien() }
            provide(name = SCHEDULERUI_NAME, isSingleton = false, definition = { AndroidSchedulers.mainThread() })
            provide(name = SCHEDULERIO_NAME, isSingleton = false, definition = { Schedulers.io() })
            provide { NetworkSchedulerImpl(get(SCHEDULERIO_NAME), get(SCHEDULERUI_NAME)) } bind NetworkScheduler::class
        }
    }

    private fun provideOkHttpClien() =
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder()
                        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .readTimeout(SOCKET_READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
            } else {
                OkHttpClient.Builder().build()
            }
}