package com.example.data.userDataSource

import com.example.data.entities.User
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {

    suspend fun addUser(user: User)

    fun getUsers(): Flow<List<User>>
}