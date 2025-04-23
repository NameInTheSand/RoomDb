package com.example.roomdb.domain.repositories

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun saveTimeStampPreference(isTimeStampVisible: Boolean)

    fun getTimeStampPreference(): Flow<Boolean>
}