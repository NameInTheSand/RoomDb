package com.example.roomdb.presentation.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.database.DatabaseHelper
import com.example.roomdb.data.entities.User
import com.example.roomdb.data.localDataSources.userDataSource.UserLocalDataSourceImpl
import com.example.roomdb.domain.repositories.UsersRepository
import com.example.roomdb.data.repository.UsersRepositoryImpl
import com.example.roomdb.domain.repositories.useCases.user.GetUsersUseCaseImpl
import com.example.roomdb.domain.repositories.useCases.user.SaveUserUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val databaseHelper = DatabaseHelper(application)
    private val usersDao = databaseHelper.getUsersDao()
    private val usersDataSource = UserLocalDataSourceImpl(usersDao)
    private val usersRepository = UsersRepositoryImpl(usersDataSource)
    private val getUsersUseCase = GetUsersUseCaseImpl(usersRepository)
    private val savedUsersUseCase = SaveUserUseCaseImpl(usersRepository)

    val users: StateFlow<List<User>> = getUsersUseCase.getUsers().stateIn(
        viewModelScope,
        SharingStarted.Companion.Lazily,
        emptyList()
    )

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            savedUsersUseCase.saveUser(user)
        }
    }
}