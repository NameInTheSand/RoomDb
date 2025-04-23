package com.example.roomdb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdb.R
import com.example.roomdb.presentation.navigation.Directions
import com.example.roomdb.presentation.navigation.Directions.AddUser
import com.example.roomdb.presentation.navigation.Directions.UsersList
import com.example.roomdb.presentation.screens.AddUserScreen
import com.example.roomdb.presentation.screens.SettingsScreen
import com.example.roomdb.presentation.screens.UsersScreen
import com.example.roomdb.presentation.viewModels.MainActivityViewModel
import com.example.roomdb.ui.theme.RoomDbTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDbTheme {
                HomeScreen(viewModel)
            }
        }
    }
}

val LocalNavController = compositionLocalOf<NavHostController> {
    throw IllegalArgumentException("No NavController provided")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MainActivityViewModel) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate(AddUser().direction)
                },
                content = {
                    Text(text = "Add")
                }
            )
        },
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.room_db_test)) },
                actions = {
                    Icon(
                        modifier = Modifier.clickable {
                            navController.navigate(Directions.Settings().route)
                        },
                        painter = painterResource(R.drawable.ic_setting),
                        contentDescription = null
                    )
                })
        }
    ) { innerPadding ->
        CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(
                navController,
                startDestination = UsersList().direction,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(UsersList().direction) {
                    UsersScreen(viewModel)
                }
                composable(AddUser().direction) {
                    AddUserScreen(viewModel)
                }
                composable(Directions.Settings().direction) {
                    SettingsScreen()
                }
            }
        }
    }
}