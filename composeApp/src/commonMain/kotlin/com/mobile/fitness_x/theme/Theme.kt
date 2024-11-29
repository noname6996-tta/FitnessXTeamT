package com.mobile.fitness_x.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.mobile.fitness_x.utils.Theme
import theme.Pink40
import theme.Pink80
import theme.Purple40
import theme.Purple80
import theme.PurpleGrey40
import theme.PurpleGrey80

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun AppTheme(
    appTheme: String?,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (appTheme) {
        Theme.LIGHT_MODE.name -> {
            LightColorScheme
        }

        Theme.DARK_MODE.name -> {
            DarkColorScheme
        }

        else -> {
            if (darkTheme) {
                DarkColorScheme
            } else {
                LightColorScheme
            }
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}