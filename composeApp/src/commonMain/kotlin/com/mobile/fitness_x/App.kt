package com.mobile.fitness_x

import androidx.compose.runtime.Composable
import com.mobile.fitness_x.screen.main.MainScreen
import com.mobile.fitness_x.screen.setting.SettingViewModel
import com.mobile.fitness_x.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    KoinContext {
        val settingViewModel = koinViewModel<SettingViewModel>()
        val currentTheme = settingViewModel.currentTheme.value
        AppTheme(currentTheme) {
            MainScreen()
        }
    }
}
