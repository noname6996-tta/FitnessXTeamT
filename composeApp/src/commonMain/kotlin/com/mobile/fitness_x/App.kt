package com.mobile.fitness_x

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobile.fitness_x.screens.main.MainScreen
import com.mobile.fitness_x.screens.setting.SettingViewModel
import com.mobile.fitness_x.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    KoinContext {
        val settingViewModel: SettingViewModel = koinViewModel()
        val currentTheme by settingViewModel.currentTheme.collectAsState()

        AppTheme(currentTheme) {
            MainScreen(settingViewModel)
        }

    }

}


