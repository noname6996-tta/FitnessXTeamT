package com.mobile.fitness_x.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mobile.fitness_x.navigation.Graph

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = rootNavController,
        startDestination = Graph.MainScreenGraph,
    ) {
        mainNavGraph(rootNavController = rootNavController, innerPadding = innerPadding)
    }
}