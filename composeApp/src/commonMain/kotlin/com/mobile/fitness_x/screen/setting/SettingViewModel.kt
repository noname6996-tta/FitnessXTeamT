package com.mobile.fitness_x.screen.setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import usecase.ChangeThemeModeUseCase
import usecase.GetThemeUseCase

class SettingViewModel(
    private val getThemeUseCase: GetThemeUseCase,
    private val changeThemeModeUseCase: ChangeThemeModeUseCase
) : ViewModel() {
    private val _currentTheme: MutableStateFlow<String?> = MutableStateFlow(null)
    val currentTheme = _currentTheme.asStateFlow()

    init {
        getCurrentTheme()
    }

    private fun getCurrentTheme() = runBlocking {
        _currentTheme.value = getThemeUseCase.invoke()
        println("longtq ${_currentTheme.value}")
    }

    fun changeThemeMode(value: String) = runBlocking {
        changeThemeModeUseCase.invoke(value)
    }
}