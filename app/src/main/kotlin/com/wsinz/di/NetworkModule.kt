package com.wsinz.di

import com.wsinz.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context
import java.util.concurrent.TimeUnit

class NetworkModule : AndroidModule() {

    private val CONNECTION_TIMEOUT_IN_SECONDS = 30L
    private val SOCKET_READ_TIMEOUT_IN_SECONDS = 30L

    override fun context(): Context = applicationContext {
        context(name = "Network") {
            provide { provideOkHttpClien() }
        }
    }

    private fun provideOkHttpClien() =
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY;
                OkHttpClient.Builder()
                        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .readTimeout(SOCKET_READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
            } else {
                OkHttpClient.Builder().build()
            }
}