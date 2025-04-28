package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.UserUi

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val dateAdded: Long = System.currentTimeMillis()
) {
    companion object {
        fun UserUi.fromUiUser(): User {
            return User(
                this.id,
                this.name,
                this.age,
                this.dateAdded
            )
        }

        fun User.toUiUser(): UserUi {
            return UserUi(
                this.id,
                this.name,
                this.age,
                this.dateAdded
            )
        }
    }
}
