package com.example.rest_api_clean.data.remote

import com.example.rest_api_clean.data.model.UserEntity
import retrofit2.http.GET

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<UserEntity>
}