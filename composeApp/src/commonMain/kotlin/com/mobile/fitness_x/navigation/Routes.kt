package com.mobile.fitness_x.navigation

object Graph {
    const val MainGraph = "mainGraph"
}

sealed class MainRouteScreen(val route: String) {
    data object Home : MainRouteScreen("home")
    data object WorkOut : MainRouteScreen("workout")
    data object Articles : MainRouteScreen("articles")
    data object Profile : MainRouteScreen("profile")
}

sealed class SettingRouteScreen(val route: String) {
    data object Settings : SettingRouteScreen("settings")
}

sealed class NotificationRouteScreen(val route: String) {
    data object Notifications : NotificationRouteScreen("notifications")
}