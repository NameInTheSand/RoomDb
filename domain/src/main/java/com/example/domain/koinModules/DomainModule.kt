package com.example.domain.koinModules

import com.example.domain.user.GetUsersUseCase
import com.example.domain.user.GetUsersUseCaseImpl
import com.example.domain.user.SaveUserUseCase
import com.example.domain.user.SaveUserUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }
    factory<SaveUserUseCase> { SaveUserUseCaseImpl(get()) }
}