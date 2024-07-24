package com.danfoleyapps.diwithkoin

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

// dont forget to add this in the manifest file
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // here we can inject the context the dependency that android needs
        initKoin{
            androidContext(this@MyApplication)
        }
    }
}