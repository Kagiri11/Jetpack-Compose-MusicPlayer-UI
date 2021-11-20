package com.example.lily

import android.app.Application
import com.example.domain.di.domainModule
import com.example.lily.di.presentationModule
import com.example.network.di.networkModule
import com.example.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class LILYApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LILYApp)
            modules(listOf(networkModule, domainModule, repositoryModule, presentationModule))
        }

        Timber.plant(Timber.DebugTree())
    }
}