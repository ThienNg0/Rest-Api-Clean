package com.example.rest_api_clean.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rest_api_clean.databinding.ActivityMainBinding
import com.example.rest_api_clean.presentation.adapters.UserAdapter
import com.example.rest_api_clean.presentation.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this // Để Data Binding theo dõi vòng đời của Activity

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Quan sát LiveData từ ViewModel
        userViewModel.users.observe(this) { userModelList ->
            userAdapter = UserAdapter(userModelList)
            recyclerView.adapter = userAdapter
        }

        // Fetch users from the API
        userViewModel.fetchUsers()
    }
}
