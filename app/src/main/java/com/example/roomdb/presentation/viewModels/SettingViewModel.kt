package com.example.roomdb.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.domain.repositories.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    val isTimeStampVisibleFlow = settingsRepository.getTimeStampPreference().stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        false
    )


    fun editTimeStampPref(isVisible: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.saveTimeStampPreference(isVisible)
        }
    }
}