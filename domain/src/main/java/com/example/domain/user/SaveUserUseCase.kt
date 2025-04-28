package com.example.domain.user

import com.example.domain.entities.UserUi

interface SaveUserUseCase {
    suspend fun saveUser(user: UserUi)
}