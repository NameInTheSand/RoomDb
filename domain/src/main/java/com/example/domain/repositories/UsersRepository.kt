package com.example.domain.repositories

import com.example.domain.entities.UserUi
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun addUser(user: UserUi)

    fun getUsers(): Flow<List<UserUi>>
}