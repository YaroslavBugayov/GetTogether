package com.gettogether.data.network.mappers

import com.gettogether.data.network.models.UserResponse
import com.gettogether.domain.mapper.Mapper
import com.gettogether.domain.models.UserProfile

class UserResponseToUserProfile : Mapper<UserResponse, UserProfile> {
    override fun map(from: UserResponse): UserProfile {
        return UserProfile(
            name = from.name,
            email = from.email,
            login = from.login,
            description = from.description
        )
    }
}