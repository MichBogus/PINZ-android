package com.wsinz.application

import android.support.multidex.MultiDexApplication
import com.wsinz.di.NetworkConnectionModule
import com.wsinz.di.NetworkModule
import com.wsinz.di.PresenterModule
import org.koin.android.ext.android.startAndroidContext

class WSINZApplication : MultiDexApplication() {

    private val modules = listOf(
            NetworkModule(),
            NetworkConnectionModule(),
            PresenterModule()
    )

    override fun onCreate() {
        super.onCreate()

        startAndroidContext(this, modules)
    }
}