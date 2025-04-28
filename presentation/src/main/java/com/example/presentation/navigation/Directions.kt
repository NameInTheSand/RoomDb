package com.example.presentation.navigation

sealed class Directions(val route: String) {
    data class UsersList(val direction: String = "users_list") : Directions(direction)
    data class AddUser(val direction: String = "add_user")  : Directions(direction)
}