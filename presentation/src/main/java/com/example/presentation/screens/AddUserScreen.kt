package com.example.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.UserUi
import com.example.presentation.LocalNavController
import com.example.presentation.viewModels.MainActivityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddUserScreen(viewModel: MainActivityViewModel = koinViewModel()) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var userNameInput by remember { mutableStateOf("") }
        var userAgeInput by remember { mutableStateOf("") }
        val navController = LocalNavController.current
        Text(text = "Add User Screen")
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = userNameInput,
            onValueChange = { userNameInput = it },
            label = { Text("Enter Name") }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = userAgeInput,
            onValueChange = { userAgeInput = it },
            label = { Text("Enter Age") }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            viewModel.addUser(
                UserUi(
                    name = userNameInput,
                    age = userAgeInput.toInt()
                )
            )
            navController.navigateUp()
        }) {
            Text("Save user")
        }
    }
}