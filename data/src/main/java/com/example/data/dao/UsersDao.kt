package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM User")
    fun getUsers(): Flow<List<User>>
}