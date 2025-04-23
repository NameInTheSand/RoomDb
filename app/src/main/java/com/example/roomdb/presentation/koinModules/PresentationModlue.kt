package com.example.roomdb.presentation.koinModules

import com.example.roomdb.presentation.viewModels.MainActivityViewModel
import com.example.roomdb.presentation.viewModels.SettingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<MainActivityViewModel> { MainActivityViewModel(get(), get(), get()) }
    viewModel<SettingViewModel> { SettingViewModel(get()) }
}