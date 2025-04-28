package com.example.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.Directions
import com.example.presentation.screens.AddUserScreen
import com.example.presentation.screens.UsersScreen
import com.example.presentation.theme.RoomDbTheme
import com.example.presentation.viewModels.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDbTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            onClick = {
                                navController.navigate(Directions.AddUser().direction)
                            },
                            content = {
                                Text(text = "Add")
                            }
                        )
                    }
                ) { innerPadding ->
                    CompositionLocalProvider(LocalNavController provides navController) {
                        NavHost(
                            navController,
                            startDestination = Directions.UsersList().direction,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Directions.UsersList().direction) {
                                UsersScreen(viewModel)
                            }
                            composable(Directions.AddUser().direction) {
                                AddUserScreen(viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

val LocalNavController = compositionLocalOf<NavController> {
    throw IllegalArgumentException("No NavController provided")
}