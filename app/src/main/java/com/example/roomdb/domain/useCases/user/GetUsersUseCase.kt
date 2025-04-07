package com.example.roomdb.domain.useCases.user

import com.example.roomdb.data.entities.User
import kotlinx.coroutines.flow.Flow

interface GetUsersUseCase {

    fun getUsers(): Flow<List<User>>
}