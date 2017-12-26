package com.wsinz.application

import android.support.multidex.MultiDexApplication
import com.wsinz.di.*
import org.koin.android.ext.android.startAndroidContext

class WSINZApplication : MultiDexApplication() {

    private val modules = listOf(
            NetworkModule(),
            NetworkConnectionModule(),
            PresenterModule(),
            NavigationModule(),
            UtilModule()
    )

    override fun onCreate() {
        super.onCreate()

        startAndroidContext(this, modules)
    }
}