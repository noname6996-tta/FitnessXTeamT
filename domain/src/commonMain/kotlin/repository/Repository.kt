package repository

interface Repository {
    suspend fun getTheme(): String
    suspend fun changeThemeMode(value: String)
}