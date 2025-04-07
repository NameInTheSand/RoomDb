package com.example.roomdb.presentation

import android.app.Application
import com.example.roomdb.data.koinModules.dataModule
import com.example.roomdb.domain.koinModules.domainModule
import com.example.roomdb.presentation.koinModules.presentationModule
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