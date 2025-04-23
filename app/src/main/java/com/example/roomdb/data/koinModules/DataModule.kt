package com.example.roomdb.data.koinModules

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.roomdb.data.dao.UsersDao
import com.example.roomdb.data.database.DatabaseHelper
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSource
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSourceImpl
import com.example.roomdb.data.repository.SettingsRepositoryImpl
import com.example.roomdb.data.repository.UsersRepositoryImpl
import com.example.roomdb.domain.repositories.SettingsRepository
import com.example.roomdb.domain.repositories.UsersRepository
import org.koin.dsl.module

fun dataModule(dataStore: DataStore<Preferences>) = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }
    single { DatabaseHelper(get()) }
    single<UsersDao> { get<DatabaseHelper>().getUsersDao() }
    single<DataStore<Preferences>> {
        dataStore
    }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}