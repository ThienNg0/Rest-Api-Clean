package com.example.rest_api_clean.domain.repository

import com.example.rest_api_clean.data.model.UserEntity

interface UserRepository {
    suspend fun getUsers(): List<UserEntity>
}