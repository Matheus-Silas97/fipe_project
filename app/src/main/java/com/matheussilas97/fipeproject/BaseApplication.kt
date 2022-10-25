package com.matheussilas97.fipeproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import di.*
import di.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            modules(
                navigationModule +
                        listOf(
                            presentationModule,
                            domainModule,
                            dataModule,
                            dataRemoteModule,
                            dataLocalModule,
                            databaseModule
                        )
            ).androidContext(applicationContext)
        }
    }
}