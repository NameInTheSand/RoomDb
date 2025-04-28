package com.example.data.userDataSource

import com.example.data.dao.UsersDao
import com.example.data.entities.User
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(
    private val usersDao: UsersDao
) : UserLocalDataSource {

    override suspend fun addUser(user: User) {
        return usersDao.addUser(user)
    }

    override fun getUsers(): Flow<List<User>> {
        return usersDao.getUsers()
    }

}