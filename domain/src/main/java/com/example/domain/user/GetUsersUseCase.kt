package com.example.domain.user

import com.example.domain.entities.UserUi
import kotlinx.coroutines.flow.Flow

interface GetUsersUseCase {

    fun getUsers(): Flow<List<UserUi>>
}