package com.example.roomdb.domain.repositories.useCases.user

import com.example.roomdb.data.entities.User
import com.example.roomdb.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCaseImpl(
    private val usersRepository: UsersRepository
) : GetUsersUseCase {

    override fun getUsers(): Flow<List<User>> {
        return usersRepository.getUsers()
    }
}