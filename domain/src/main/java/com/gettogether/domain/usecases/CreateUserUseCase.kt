package com.gettogether.domain.usecases

import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.models.UserProfile
import com.gettogether.domain.repositories.UserRepository
import com.gettogether.domain.utils.Resource

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(user: UserBasicInfo) : Resource<UserProfile> {
        return userRepository.createUser(user)
    }
}