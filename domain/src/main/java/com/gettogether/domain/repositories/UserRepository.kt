package com.gettogether.domain.repositories

import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.models.UserProfile
import com.gettogether.domain.utils.Resource

interface UserRepository {
    suspend fun createUser(user: UserBasicInfo) : Resource<UserProfile>
}