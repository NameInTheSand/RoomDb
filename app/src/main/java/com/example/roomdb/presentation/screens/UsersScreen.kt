package com.example.roomdb.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.presentation.viewModels.MainActivityViewModel
import com.example.roomdb.presentation.listItems.UserListItem

@Composable
fun UsersScreen(viewModel: MainActivityViewModel = viewModel()) {
    val users = viewModel.users.collectAsState()
    LazyColumn {
        items(users.value) { user ->
            UserListItem(user)
            HorizontalDivider()
        }
    }
}