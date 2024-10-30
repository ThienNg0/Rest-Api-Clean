package com.example.rest_api_clean.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rest_api_clean.data.model.UserEntity
import com.example.rest_api_clean.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<UserEntity>>()
    val users: LiveData<List<UserEntity>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = getUsersUseCase()
                _users.postValue(userList)
            } catch (e: Exception) {
                // Xử lý lỗi (thông báo cho người dùng, log, v.v.)
            }
        }
    }
}