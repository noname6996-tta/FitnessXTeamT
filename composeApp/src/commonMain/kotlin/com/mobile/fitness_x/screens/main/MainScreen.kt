package com.mobile.fitness_x.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobile.fitness_x.components.AppBottomNavigationBar
import com.mobile.fitness_x.navigation.NavigationItem
import com.mobile.fitness_x.navigation.graphs.RootNavGraph
import com.mobile.fitness_x.screens.setting.SettingViewModel
import com.mobile.fitness_x.utils.navigationItemsLists

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen(settingViewModel: SettingViewModel) {
    val windowSizeClass = calculateWindowSizeClass()
    val isMediumExpandedWWSC by remember(windowSizeClass) {
        derivedStateOf {
            windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact
        }
    }
    val rootNavController = rememberNavController()
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val navigationItem by remember {
        derivedStateOf {
            navigationItemsLists.find { it.route == currentRoute }
        }
    }
    val isBottomBarVisible by remember(isMediumExpandedWWSC) {
        derivedStateOf {
            if (!isMediumExpandedWWSC) {
                navigationItem != null
            } else {
                false
            }
        }
    }

    MainScaffold(
        rootNavController = rootNavController,
        currentRoute = currentRoute,
        isBottomBarVisible = isBottomBarVisible,
        onItemClick = { currentNavigationItem ->
            rootNavController.navigate(currentNavigationItem.route) {
                rootNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                    popUpTo(startDestinationRoute) {
                        saveState = true
                    }
                }
                launchSingleTop = true

                restoreState = true
            }

        },
        settingViewModel = settingViewModel
    )
}

@Composable
fun MainScaffold(
    rootNavController: NavHostController,
    currentRoute: String?,
    isBottomBarVisible: Boolean,
    onItemClick: (NavigationItem) -> Unit,
    settingViewModel: SettingViewModel
) {
        Scaffold(
            modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
            bottomBar = {
                AnimatedVisibility(
                    visible = isBottomBarVisible,
                    enter = slideInVertically(
                        initialOffsetY = { fullHeight -> fullHeight }
                    ),
                    exit = slideOutVertically(
                        targetOffsetY = { fullHeight -> fullHeight }
                    )
                ) {
                    AppBottomNavigationBar(
                        items = navigationItemsLists,
                        currentRoute = currentRoute,
                        onItemClick = { currentNavigationItem ->
                            onItemClick(currentNavigationItem)
                        }
                    )
                }
            }
        ) { innerPadding ->
            RootNavGraph(
                rootNavController = rootNavController,
                innerPadding = innerPadding,
                settingViewModel = settingViewModel
            )
        }

}