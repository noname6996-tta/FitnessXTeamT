package com.mobile.fitness_x.screens.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import usecase.ChangeThemeModeUseCase
import usecase.GetThemeUseCase

class SettingViewModel(
    private val getThemeUseCase: GetThemeUseCase,
    private val changeThemeModeUseCase: ChangeThemeModeUseCase
) : ViewModel() {

    private val _currentTheme: MutableStateFlow<String?> = MutableStateFlow(null)
    val currentTheme = _currentTheme.asStateFlow()

    init {
        currentThemeGet()
    }

    private fun currentThemeGet() = viewModelScope.launch {
        _currentTheme.value = getThemeUseCase.invoke()
    }

    fun changeThemeMode(value: String) = viewModelScope.launch {
        changeThemeModeUseCase.invoke(value)
        _currentTheme.value = value
    }
}