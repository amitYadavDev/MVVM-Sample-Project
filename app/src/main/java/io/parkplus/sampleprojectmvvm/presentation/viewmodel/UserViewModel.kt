package io.parkplus.sampleprojectmvvm.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.parkplus.sampleprojectmvvm.domain.model.User
import io.parkplus.sampleprojectmvvm.domain.usecases.GetUsersUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class UserViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase): ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            _users.value = getUsersUseCase()
            Log.i("users_data", " ${Thread.currentThread().name}")
        }
    }
}