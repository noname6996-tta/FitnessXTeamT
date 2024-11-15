package repository

import preferences.AppPreferences

class RepositoryImpl(
    private val appPreferences: AppPreferences
) : Repository {

    override suspend fun getTheme(): String {
        return appPreferences.getTheme()
    }

    override suspend fun changeThemeMode(value: String) {
        appPreferences.changeThemeMode(value)
    }
}