package com.example.rest_api_clean.domain.usecase

import com.example.rest_api_clean.data.model.UserEntity
import com.example.rest_api_clean.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<UserEntity> {
        return userRepository.getUsers()
    }
}