package com.example.rest_api_clean.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rest_api_clean.domain.usecase.GetUsersUseCase
import com.example.rest_api_clean.presentation.model.UserModel
import com.example.rest_api_clean.presentation.model.toUserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                // Lấy danh sách UserEntity từ UseCase
                val userList = getUsersUseCase()
                // Chuyển đổi UserEntity sang UserModel
                val userModelList = userList.map { it.toUserModel() }
                // Cập nhật LiveData với danh sách UserModel
                _users.postValue(userModelList)
            } catch (e: Exception) {
                // Xử lý lỗi nếu có
            }
        }
    }
}
