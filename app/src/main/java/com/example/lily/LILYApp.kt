package com.example.lily

import android.app.Application
import com.example.domain.di.domainModule
import com.example.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class LILYApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LILYApp)
            modules(listOf(networkModule, domainModule))
        }

        Timber.plant(Timber.DebugTree())
    }
}