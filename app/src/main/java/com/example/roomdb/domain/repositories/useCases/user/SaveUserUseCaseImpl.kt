package com.example.roomdb.domain.repositories.useCases.user

import com.example.roomdb.data.entities.User
import com.example.roomdb.domain.repositories.UsersRepository

class SaveUserUseCaseImpl(
    private val usersRepository: UsersRepository
) : SaveUserUseCase  {

    override suspend fun saveUser(user: User) {
        usersRepository.addUser(user)
    }

}