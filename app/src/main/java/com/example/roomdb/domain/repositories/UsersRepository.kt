package com.example.roomdb.domain.repositories

import com.example.roomdb.data.entities.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun addUser(user: User)

    fun getUsers(): Flow<List<User>>
}