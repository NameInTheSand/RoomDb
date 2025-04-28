package com.example.domain.entities

data class UserUi(
    val id: Int = 0,
    val name: String,
    val age: Int,
    val dateAdded: Long = System.currentTimeMillis()
)
