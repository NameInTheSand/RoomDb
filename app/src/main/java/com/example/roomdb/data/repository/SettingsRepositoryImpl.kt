package com.example.roomdb.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.roomdb.domain.repositories.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val TIMESTAMP_PREF_NAME = "timestamp"

class SettingsRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    val timeStampPreference = booleanPreferencesKey(TIMESTAMP_PREF_NAME)

    override suspend fun saveTimeStampPreference(isTimeStampVisible: Boolean) {
        dataStore.edit {
            it[timeStampPreference] = isTimeStampVisible
        }
    }

    override fun getTimeStampPreference(): Flow<Boolean> {
        return dataStore.data.map { it[timeStampPreference] == true }
    }

}