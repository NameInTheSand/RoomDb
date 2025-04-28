package com.example.roomdb

import android.app.Application
import com.example.data.koinModules.dataModule
import com.example.domain.koinModules.domainModule
import com.example.presentation.koinModules.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UsersApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UsersApp)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}