package com.example.domain.user

import com.example.domain.entities.UserUi
import com.example.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCaseImpl(
    private val usersRepository: UsersRepository
) : GetUsersUseCase {

    override fun getUsers(): Flow<List<UserUi>> {
        return usersRepository.getUsers()
    }
}