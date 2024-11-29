package com.mobile.fitness_x.screens.articles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavController
import com.mobile.fitness_x.components.AppTopBar
import com.mobile.fitness_x.navigation.SettingRouteScreen
import fitness_x.composeapp.generated.resources.Res
import fitness_x.composeapp.generated.resources.bottom_articles
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArticlesScreen(
    rootNavController: NavController,
    paddingValues: PaddingValues
) {
    val viewModel = koinViewModel<ArticlesViewModel>()

    val originDirection = LocalLayoutDirection.current

    Column(
        modifier = Modifier.fillMaxSize().padding(
            start = paddingValues.calculateStartPadding(originDirection),
            end = paddingValues.calculateEndPadding(originDirection),
            bottom = paddingValues.calculateBottomPadding(),
        ),
    ) {
        AppTopBar(
            isNotMainRoute = true,
            isShowIconEnd = false,
            title = stringResource(Res.string.bottom_articles),
            onClickSettings = {
                rootNavController.navigate(SettingRouteScreen.Settings.route)
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Text(
                text = "Articles",
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}