package com.example.roomdb.data.database

import android.content.Context
import androidx.room.Room
import com.example.roomdb.data.dao.UsersDao

private const val dbName = "database-name"

class DatabaseHelper(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "notes_db"
    ).addMigrations(MIGRATION_1_2)
        .build()

    fun getUsersDao(): UsersDao {
        return database.usersDao()
    }
}