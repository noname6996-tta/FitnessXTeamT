package com.mobile.fitness_x.screens.notification

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.fitness_x.components.AppTopBar

@Composable
fun NotificationScreen(
    rootNavController: NavController,
    innerPadding: PaddingValues
) {
    Scaffold(
        topBar = {
            AppTopBar(
                isNotMainRoute = false,
                title = "Notification",
                onClickBack = {
                    rootNavController.navigateUp()
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {

        }
    }
}