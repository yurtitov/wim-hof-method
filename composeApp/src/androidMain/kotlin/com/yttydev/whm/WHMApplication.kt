package com.yttydev.whm

import android.app.Application
import com.yttydev.whm.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WHMApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WHMApplication)
            androidLogger()
            modules(appModules)
        }
    }
}
