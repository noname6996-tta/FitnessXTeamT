package com.mobile.fitness_x.utils

import com.mobile.fitness_x.navigation.MainRouteScreen
import com.mobile.fitness_x.navigation.NavigationItem
import fitness_x.composeapp.generated.resources.Res
import fitness_x.composeapp.generated.resources.bottom_articles
import fitness_x.composeapp.generated.resources.bottom_home
import fitness_x.composeapp.generated.resources.bottom_profile
import fitness_x.composeapp.generated.resources.bottom_workout
import fitness_x.composeapp.generated.resources.dark_mode
import fitness_x.composeapp.generated.resources.ic_dumbbell
import fitness_x.composeapp.generated.resources.ic_home
import fitness_x.composeapp.generated.resources.ic_profile
import fitness_x.composeapp.generated.resources.ic_star
import fitness_x.composeapp.generated.resources.light_mode
import fitness_x.composeapp.generated.resources.system_default
import org.jetbrains.compose.resources.StringResource


val navigationItemsLists = listOf(
    NavigationItem(
        icon = Res.drawable.ic_home,
        title = Res.string.bottom_home,
        route = NavigationRoute.HOME.route
    ), NavigationItem(
        icon = Res.drawable.ic_dumbbell,
        title = Res.string.bottom_workout,
        route = NavigationRoute.WORKOUT.route
    ), NavigationItem(
        icon = Res.drawable.ic_star,
        title = Res.string.bottom_articles,
        route = NavigationRoute.ARTICLES.route
    ), NavigationItem(
        icon = Res.drawable.ic_profile,
        title = Res.string.bottom_profile,
        route = NavigationRoute.PROFILE.route
    )
)

enum class NavigationRoute(val route: String) {
    HOME(MainRouteScreen.Home.route),
    WORKOUT(MainRouteScreen.WorkOut.route),
    ARTICLES(MainRouteScreen.Articles.route),
    PROFILE(MainRouteScreen.Profile.route)
}

enum class Theme(val title: StringResource) {
    SYSTEM_DEFAULT(Res.string.system_default),
    LIGHT_MODE(Res.string.light_mode),
    DARK_MODE(Res.string.dark_mode)
}