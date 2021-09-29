package com.lja.numeriqsampleapp

import android.app.Application
import com.lja.numeriqsampleapp.di.appModule
import com.lja.numeriqsampleapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ArticlesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(applicationContext)
            modules(listOf(appModule, viewModelModule))
        }
    }
}