package com.example.roomdb.data.database

import android.content.Context
import androidx.room.Room

private const val dbName = "database-name"

class DatabaseHelper(context: Context) {
    val database: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "notes_db"
    ).addMigrations(MIGRATION_1_2)
        .build()
}