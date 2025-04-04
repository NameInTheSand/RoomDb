package com.example.roomdb.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.data.dao.UsersDao
import com.example.roomdb.data.entities.User

@Database(
    entities = [User::class], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}