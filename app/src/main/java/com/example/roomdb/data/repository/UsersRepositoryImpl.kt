package com.example.roomdb.data.repository

import com.example.roomdb.data.entities.User
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSource
import com.example.roomdb.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.Flow

class UsersRepositoryImpl(
    private val localDataSource: UserLocalDataSource
) : UsersRepository {

    override suspend fun addUser(user: User) {
        localDataSource.addUser(user)
    }

    override fun getUsers(): Flow<List<User>> {
        return localDataSource.getUsers()
    }

}