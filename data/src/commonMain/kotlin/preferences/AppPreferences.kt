package preferences


interface AppPreferences {
    suspend fun getTheme(): String
    suspend fun changeThemeMode(value: String)
}