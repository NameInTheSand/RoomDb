package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.UsersDao
import com.example.data.entities.User

@Database(
    entities = [User::class], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}