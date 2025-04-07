package com.example.roomdb.serviceLocator

import android.annotation.SuppressLint
import android.content.Context
import com.example.roomdb.data.database.DatabaseHelper
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSourceImpl
import com.example.roomdb.data.repository.UsersRepositoryImpl
import com.example.roomdb.domain.repositories.useCases.user.GetUsersUseCaseImpl
import com.example.roomdb.domain.repositories.useCases.user.SaveUserUseCaseImpl

@SuppressLint("StaticFieldLeak")
object ServiceLocator {
    @JvmStatic
    var appContext: Context? = null
    val userDao by lazy { appDatabase.usersDao() }
    val appDatabase by lazy { DatabaseHelper(appContext!!).database }
    val userLocalDataSource by lazy { UserLocalDataSourceImpl(userDao) }
    val usersRepository by lazy { UsersRepositoryImpl(userLocalDataSource) }
    val getUsersUseCase by lazy { GetUsersUseCaseImpl(usersRepository) }
    val saveUserUseCase by lazy { SaveUserUseCaseImpl(usersRepository) }

    fun setContext(context: Context) {
        this.appContext = context
    }

}