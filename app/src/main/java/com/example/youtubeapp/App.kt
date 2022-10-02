package com.example.youtubeapp

import android.app.Application
import com.example.youtubeapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()



        startKoin {

            androidContext(this@App)

            modules(listOf(vmModule, appModule, networkModule, repositoryModule, localModule))
        }
    }



}