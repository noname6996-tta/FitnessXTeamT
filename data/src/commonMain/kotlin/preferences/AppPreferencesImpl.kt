package preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AppPreferencesImpl(
    private val dataStore: DataStore<Preferences>

) : AppPreferences {
    private val themeKey = stringPreferencesKey("theme")

    override suspend fun getTheme(): String {
        return dataStore.data.map { preferences -> preferences[themeKey] }.first() ?: "LIGHT_MODE"
    }

    override suspend fun changeThemeMode(value: String) {
        dataStore.edit { preferences ->
            preferences[themeKey] = value
        }
    }
}