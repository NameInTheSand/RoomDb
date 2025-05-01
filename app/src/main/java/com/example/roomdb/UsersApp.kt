package com.example.roomdb

import android.app.Application
import android.util.Log
import com.example.data.koinModules.dataModule
import com.example.domain.koinModules.domainModule
import com.example.presentation.koinModules.presentationModule
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

private const val TAG = "APP_TAG"
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

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d(TAG, "FCM Token: $token")
        }
    }
}