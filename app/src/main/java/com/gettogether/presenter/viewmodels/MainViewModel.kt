package com.gettogether.presenter.viewmodels

import androidx.lifecycle.MutableLiveData
import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.usecases.CreateUserUseCase

class MainViewModel(
    private val getUsersUseCase: CreateUserUseCase
) {
    private val _users = MutableLiveData<List<UserBasicInfo>>()
    val users: MutableLiveData<List<UserBasicInfo>> = _users

    fun createUser() {
//        viewModelScope.launch {
//
//        }
//        _users.value = getUsersUseCase.execute().data!!
    }
}