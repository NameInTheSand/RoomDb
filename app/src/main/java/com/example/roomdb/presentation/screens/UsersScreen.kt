package com.example.roomdb.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.roomdb.presentation.listItems.UserListItem
import com.example.roomdb.presentation.viewModels.MainActivityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(viewModel: MainActivityViewModel = koinViewModel()) {
    val users = viewModel.users.collectAsState()
    val isTimeStampVisible by viewModel.isTimeStampVisibleFlow.collectAsState()
    LazyColumn {
        items(users.value) { user ->
            UserListItem(user, isTimeStampVisible)
            HorizontalDivider()
        }
    }
}