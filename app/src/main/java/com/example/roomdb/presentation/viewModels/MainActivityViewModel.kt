package com.example.roomdb.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.entities.User
import com.example.roomdb.domain.repositories.useCases.user.GetUsersUseCase
import com.example.roomdb.domain.repositories.useCases.user.SaveUserUseCase
import com.example.roomdb.serviceLocator.ServiceLocator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainActivityViewModel(
    getUsersUseCase: GetUsersUseCase = ServiceLocator.getUsersUseCase,
    private val savedUsersUseCase: SaveUserUseCase = ServiceLocator.saveUserUseCase
) : ViewModel() {

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