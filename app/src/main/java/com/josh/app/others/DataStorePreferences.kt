package com.josh.app.others

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getFirstRun(): Flow<Boolean> {
        return dataStore.data.map {
            it[FIRST_RUN] ?: false
        }
    }

    suspend fun setFirstRun(value: Boolean) {
        dataStore.edit {
            it[FIRST_RUN] = value
        }
    }

    companion object {
        private val FIRST_RUN = booleanPreferencesKey("first_run")

        @Volatile
        private var INSTANCE: DataStorePreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): DataStorePreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = DataStorePreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}