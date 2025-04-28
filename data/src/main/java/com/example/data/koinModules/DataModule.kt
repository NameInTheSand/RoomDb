package com.example.data.koinModules

import com.example.data.dao.UsersDao
import com.example.data.database.DatabaseHelper
import com.example.data.repository.UsersRepositoryImpl
import com.example.data.userDataSource.UserLocalDataSource
import com.example.data.userDataSource.UserLocalDataSourceImpl
import com.example.domain.repositories.UsersRepository
import org.koin.dsl.module

val dataModule = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }
    single { DatabaseHelper(get()) }
    single<UsersDao> { get<DatabaseHelper>().getUsersDao() }
}