package com.testgithub

import android.app.Application
import androidekb.com.moviestest.BuildConfig
import androidekb.com.moviestest.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@App)
            modules(KoinModules.create())
        }
    }
}