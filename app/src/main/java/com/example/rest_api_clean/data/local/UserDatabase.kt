package com.example.rest_api_clean.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rest_api_clean.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}