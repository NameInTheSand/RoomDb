package com.example.roomdb.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.entities.User
import com.example.roomdb.domain.useCases.user.GetUsersUseCase
import com.example.roomdb.domain.useCases.user.SaveUserUseCase
import com.example.roomdb.domain.useCases.work.AddRandomEntityUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    getUsersUseCase: GetUsersUseCase,
    addRandomEntityUseCase: AddRandomEntityUseCase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            addRandomEntityUseCase.addRandomEntity()
        }
    }
    val users: StateFlow<List<User>> = getUsersUseCase.getUsers().stateIn(
        viewModelScope,
        SharingStarted.Companion.Lazily,
        emptyList()
    )

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase.saveUser(user)
        }
    }
}