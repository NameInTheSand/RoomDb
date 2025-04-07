package com.example.roomdb.domain.useCases.user

import com.example.roomdb.data.entities.User

interface SaveUserUseCase {
    suspend fun saveUser(user: User)
}