package com.example.hinova

import android.app.Application
import com.example.hinova.di.loadRepositories
import com.example.hinova.di.loadServices
import com.example.hinova.di.loadViewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            }
            androidContext(this@MyApp)
            modules(loadViewModels, loadRepositories, loadServices)
        }
    }
}