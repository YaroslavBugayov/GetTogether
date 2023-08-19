package com.gettogether.presenter.di

import com.gettogether.data.network.mappers.UserResponseToUserProfile
import com.gettogether.data.network.models.UserResponse
import com.gettogether.data.network.repositories.UserRepositoryImpl
import com.gettogether.data.network.services.UserService
import com.gettogether.domain.mapper.Mapper
import com.gettogether.domain.models.UserProfile
import com.gettogether.domain.repositories.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> {
        UserRepositoryImpl(userService = get(), userMapper = get())
    }

    single<Mapper<UserResponse, UserProfile>> {
        UserResponseToUserProfile()
    }

    single<UserService> {
        UserService()
    }
}