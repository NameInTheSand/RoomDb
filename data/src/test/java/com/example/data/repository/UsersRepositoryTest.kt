package com.example.data.repository

import com.example.data.entities.User
import com.example.data.userDataSource.UserLocalDataSource
import com.example.domain.entities.UserUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test


class UsersRepositoryTest {

    private val usersRepository by lazy { UsersRepositoryImpl(MockLocalDataSource()) }


    @Test
    fun `check user added to database`() = runBlocking {
        val user = getUser(21)
        usersRepository.addUser(user)
        usersRepository.getUsers().collect {
            assert(it.size == 1)
            assert(it.first().age == 21)
            assert(it.first().name == "Sam")
            assert(it.first().id == 0)
        }
    }

    @Test
    fun `check all users provided correctly`() = runBlocking {
        val user1 = getUser(21)
        val user2 = getUser(33)
        val user3 = getUser(44)
        usersRepository.addUser(user1)
        usersRepository.addUser(user2)
        usersRepository.addUser(user3)
        usersRepository.getUsers().collect {
            assert(it.size == 3)
            assert(it[0].age == 21)
            assert(it[1].age == 33)
            assert(it[2].age == 44)
        }
    }

    private fun getUser(age: Int): UserUi {
        return UserUi(
            name = "Sam",
            age = age,
        )
    }

    private class MockLocalDataSource : UserLocalDataSource {
        private val users = mutableListOf<User>()

        override suspend fun addUser(user: User) {
            users.add(user)
        }

        override fun getUsers(): Flow<List<User>> {
            return flow {
                emit(users)
            }
        }

    }
}