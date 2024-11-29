package com.mobile.fitness_x.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.fitness_x.navigation.Graph
import com.mobile.fitness_x.navigation.SettingRouteScreen
import com.mobile.fitness_x.screens.setting.SettingScreen
import com.mobile.fitness_x.screens.setting.SettingViewModel

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    innerPadding: PaddingValues,
    settingViewModel: SettingViewModel
) {
    NavHost(
        navController = rootNavController,
        startDestination = Graph.MainGraph,
    ) {
        mainNavGraph(rootNavController = rootNavController, innerPadding = innerPadding)
        composable(
            route = SettingRouteScreen.Settings.route,
        ) {
            SettingScreen(
                navController = rootNavController,
                settingViewModel = settingViewModel
            )
        }
    }
}