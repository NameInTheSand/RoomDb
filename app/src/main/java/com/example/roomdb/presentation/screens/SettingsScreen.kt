package com.example.roomdb.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.roomdb.presentation.viewModels.SettingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(viewModel: SettingViewModel = koinViewModel()) {

    val isTimeStampVisible by viewModel.isTimeStampVisibleFlow.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Switch(
            isTimeStampVisible,
            onCheckedChange = { viewModel.editTimeStampPref(it) }
        )
    }
}