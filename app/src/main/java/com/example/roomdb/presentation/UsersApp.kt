package com.example.roomdb.presentation

import android.app.Application
import com.example.roomdb.serviceLocator.ServiceLocator

class UsersApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.setContext(this)
    }
}