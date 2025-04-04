package com.example.roomdb.domain.repositories.useCases.user

import com.example.roomdb.data.entities.User

interface SaveUserUseCase {
    suspend fun saveUser(user: User)
}