package com.gettogether.presenter.di

import com.gettogether.domain.usecases.CreateUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<CreateUserUseCase> {
        CreateUserUseCase(userRepository = get())
    }
}