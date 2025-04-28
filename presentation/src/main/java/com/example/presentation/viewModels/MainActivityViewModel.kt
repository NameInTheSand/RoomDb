package com.example.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.UserUi
import com.example.domain.user.GetUsersUseCase
import com.example.domain.user.SaveUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val users: StateFlow<List<UserUi>> = getUsersUseCase.getUsers().stateIn(
        viewModelScope,
        SharingStarted.Companion.Lazily,
        emptyList()
    )

    fun addUser(user: UserUi) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase.saveUser(user)
        }
    }
}