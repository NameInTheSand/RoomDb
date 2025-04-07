package com.example.roomdb.data.koinModules

import com.example.roomdb.data.dao.UsersDao
import com.example.roomdb.data.database.DatabaseHelper
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSource
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSourceImpl
import com.example.roomdb.data.repository.UsersRepositoryImpl
import com.example.roomdb.domain.repositories.UsersRepository
import org.koin.dsl.module

val dataModule = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }
    single { DatabaseHelper(get()) }
    single<UsersDao> { get<DatabaseHelper>().getUsersDao() }
}