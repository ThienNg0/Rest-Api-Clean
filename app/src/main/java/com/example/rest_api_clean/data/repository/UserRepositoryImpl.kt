package com.example.rest_api_clean.data.repository

import com.example.rest_api_clean.data.local.UserDao
import com.example.rest_api_clean.data.model.UserEntity
import com.example.rest_api_clean.data.remote.UserApiService
import com.example.rest_api_clean.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userApiService: UserApiService
) : UserRepository {
    override suspend fun getUsers(): List<UserEntity> {
        val users = userApiService.getUsers()
        userDao.insertAll(users)
        return userDao.getAllUsers()
    }
}