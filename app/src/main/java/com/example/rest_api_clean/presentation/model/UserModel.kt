package com.example.rest_api_clean.presentation.model

import com.example.rest_api_clean.data.model.UserEntity

data class UserModel(val id: Int, val name: String, val email: String)

fun UserEntity.toUserModel(): UserModel {
    return UserModel(id = this.id, name = this.name, email = this.email)
}