package com.gettogether.data.network.repositories

import com.gettogether.data.network.models.UserResponse
import com.gettogether.data.network.services.UserService
import com.gettogether.domain.mapper.Mapper
import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.models.UserProfile
import com.gettogether.domain.repositories.UserRepository
import com.gettogether.domain.utils.Resource

class UserRepositoryImpl(
    private val userService: UserService,
    private val userMapper: Mapper<UserResponse, UserProfile>
) : UserRepository {
    override suspend fun createUser(user: UserBasicInfo): Resource<UserProfile> {
        return when (val response = userService.createUser(user)) {
            is Resource.Error -> Resource.Error(response.error!!)
            is Resource.Success -> {
                if (response.data != null) {
                    return Resource.Success(
                        userMapper.map(response.data!!)
                    )
                } else {
                    return Resource.Success()
                }
            }
        }
    }
}