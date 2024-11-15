package com.mobile.fitness_x.navigation

object Graph {
    const val MainScreenGraph = "mainScreenGraph"
}

sealed class MainRouteScreen(val route: String) {
    data object Home : MainRouteScreen("home")
    data object WorkOut : MainRouteScreen("workout")
    data object Articles : MainRouteScreen("articles")
    data object Profile : MainRouteScreen("profile")
}