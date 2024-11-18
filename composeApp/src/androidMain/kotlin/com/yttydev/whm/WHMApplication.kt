package com.yttydev.whm

import android.app.Application

class WHMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: Application? = null
    }
}
