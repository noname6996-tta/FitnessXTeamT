package com.mobile.fitness_x

import android.app.Application
import com.mobile.fitness_x.di.viewModelModule
import di.androidSharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = viewModelModule + androidSharedModule

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(modules)
        }
    }
}