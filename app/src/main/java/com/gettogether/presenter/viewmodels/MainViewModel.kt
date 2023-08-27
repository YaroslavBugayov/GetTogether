package com.gettogether.presenter.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.models.UserProfile
import com.gettogether.domain.usecases.CreateUserUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUsersUseCase: CreateUserUseCase
) : ViewModel() {
    private val _users = MutableLiveData<UserProfile>()
    val users: MutableLiveData<UserProfile> = _users


    fun createUser(user: UserBasicInfo) {
        viewModelScope.launch {
            _users.value = getUsersUseCase.execute(user).data!!
        }
    }
}