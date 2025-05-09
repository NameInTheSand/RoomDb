package com.example.presentation.listItems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.UserUi

@Composable
fun UserListItem(user: UserUi) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Name: " + user.name
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Age : ${user.age}"
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text("Date added: ${user.dateAdded}")
        Spacer(modifier = Modifier.height(5.dp))
    }
}