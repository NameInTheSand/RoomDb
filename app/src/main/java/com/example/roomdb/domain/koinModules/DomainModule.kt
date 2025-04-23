package com.example.roomdb.domain.koinModules

import com.example.roomdb.domain.useCases.user.GetUsersUseCase
import com.example.roomdb.domain.useCases.user.GetUsersUseCaseImpl
import com.example.roomdb.domain.useCases.user.SaveUserUseCase
import com.example.roomdb.domain.useCases.user.SaveUserUseCaseImpl
import com.example.roomdb.domain.useCases.work.AddRandomEntityUseCase
import com.example.roomdb.domain.useCases.work.AddRandomEntityUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }
    factory<SaveUserUseCase> { SaveUserUseCaseImpl(get()) }
    factory<AddRandomEntityUseCase> { AddRandomEntityUseCaseImpl(get()) }
}