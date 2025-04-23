package com.example.roomdb.presentation

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.roomdb.data.koinModules.dataModule
import com.example.roomdb.domain.koinModules.domainModule
import com.example.roomdb.presentation.koinModules.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UsersApp : Application() {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UsersApp)
            modules(
                presentationModule,
                domainModule,
                dataModule(dataStore)
            )
        }
    }
}