package com.mobile.fitness_x.screens.articles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArticlesScreen(
    rootNavController: NavController,
    paddingValues: PaddingValues
) {
    val viewModel = koinViewModel<ArticlesViewModel>()

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