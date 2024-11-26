package com.mobile.fitness_x.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mobile.fitness_x.navigation.Graph
import com.mobile.fitness_x.navigation.MainRouteScreen
import com.mobile.fitness_x.screens.articles.ArticlesScreen
import com.mobile.fitness_x.screens.home.HomeScreen
import com.mobile.fitness_x.screens.profile.ProfileScreen
import com.mobile.fitness_x.screens.workout.WorkOutScreen

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    innerPadding: PaddingValues
) {
    navigation(
        startDestination = MainRouteScreen.Home.route,
        route = Graph.MainScreenGraph
    ) {
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.WorkOut.route) {
            WorkOutScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.Articles.route) {
            ArticlesScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.Profile.route) {
            ProfileScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
    }

}