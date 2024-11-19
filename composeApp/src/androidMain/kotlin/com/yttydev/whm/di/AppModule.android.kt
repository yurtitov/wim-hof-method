package com.yttydev.whm.di

import com.yttydev.whm.WHMApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.dsl.koinConfiguration

actual fun nativeConfig() = koinConfiguration {
    androidLogger()
    androidContext(WHMApplication.instance ?: error("No Android application context set"))
}