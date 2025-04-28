package com.example.data.repository

import com.example.data.entities.User.Companion.fromUiUser
import com.example.data.entities.User.Companion.toUiUser
import com.example.data.userDataSource.UserLocalDataSource
import com.example.domain.entities.UserUi
import com.example.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsersRepositoryImpl(
    private val localDataSource: UserLocalDataSource
) : UsersRepository {

    override suspend fun addUser(user: UserUi) {
        localDataSource.addUser(user.fromUiUser())
    }

    override fun getUsers(): Flow<List<UserUi>> {
        return localDataSource.getUsers().map {
            it.map { user ->
                user.toUiUser()
            }
        }
    }

}