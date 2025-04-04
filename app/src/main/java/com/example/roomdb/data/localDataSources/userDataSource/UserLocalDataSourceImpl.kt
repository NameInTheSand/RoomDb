package com.example.roomdb.data.localDataSources.userDataSource

import com.example.roomdb.data.dao.UsersDao
import com.example.roomdb.data.entities.User
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