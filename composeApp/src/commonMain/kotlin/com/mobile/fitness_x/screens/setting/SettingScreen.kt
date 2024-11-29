package com.mobile.fitness_x.screens.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.fitness_x.components.AppTopBar
import com.mobile.fitness_x.screens.setting.components.SettingItem
import com.mobile.fitness_x.screens.setting.components.ThemeSelectionDialog
import com.mobile.fitness_x.utils.Theme
import fitness_x.composeapp.generated.resources.Res
import fitness_x.composeapp.generated.resources.ic_light_mode
import fitness_x.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun SettingScreen(
    navController: NavController,
    settingViewModel: SettingViewModel
) {
    var showThemeSelectionDialog by remember { mutableStateOf(false) }
    val currentTheme by settingViewModel.currentTheme.collectAsState()
    when {
        showThemeSelectionDialog -> {
            ThemeSelectionDialog(
                onThemeChange = { theme ->
                    settingViewModel.changeThemeMode(theme.name)
                    showThemeSelectionDialog = false
                },
                onDismissRequest = { showThemeSelectionDialog = false },
                currentTheme = currentTheme ?: Theme.LIGHT_MODE.name
            )
        }
    }
    Scaffold(
        topBar = {
            AppTopBar(
                isShowAvatar = false,
                isNotMainRoute = false,
                title = "Setting",
                onClickBack = {
                    navController.navigateUp()
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            item {
                SettingItem(
                    onClick = {
                        showThemeSelectionDialog = true
                    },
                    painter = painterResource(Res.drawable.ic_light_mode),
                    itemName = stringResource(Res.string.theme)
                )
            }
        }

    }
}
