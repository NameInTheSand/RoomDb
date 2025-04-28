package com.example.presentation.koinModules

import com.example.presentation.viewModels.MainActivityViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<MainActivityViewModel> { MainActivityViewModel(get(), get()) }
}