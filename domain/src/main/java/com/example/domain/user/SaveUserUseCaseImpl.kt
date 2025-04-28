package com.example.domain.user

import com.example.domain.entities.UserUi
import com.example.domain.repositories.UsersRepository

class SaveUserUseCaseImpl(
    private val usersRepository: UsersRepository
) : SaveUserUseCase {

    override suspend fun saveUser(user: UserUi) {
        usersRepository.addUser(user)
    }

}