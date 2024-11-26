package com.mobile.fitness_x.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.mobile.fitness_x.utils.NavigationRoute
import fitness_x.composeapp.generated.resources.Res
import fitness_x.composeapp.generated.resources.ic_bell
import fitness_x.composeapp.generated.resources.ic_setting
import fitness_x.composeapp.generated.resources.test
import org.jetbrains.compose.resources.painterResource
import theme.lavenderBlue

@Composable
fun AppTopBar(
    currentRoute: String,
    onClickNotification: () -> Unit = {},
    onClickSettings: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        if (currentRoute == NavigationRoute.HOME.route) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = onClickNotification),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = Res.drawable.test,
                    contentDescription = "Notification",
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White, shape = CircleShape)
                )
            }
        }

        Text(
            text = currentRoute,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
        )

        if (currentRoute == NavigationRoute.HOME.route || currentRoute == NavigationRoute.PROFILE.route) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = {
                        if (currentRoute == NavigationRoute.HOME.route) onClickNotification() else onClickSettings()
                    })
                    .background(lavenderBlue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(
                        if (currentRoute == NavigationRoute.HOME.route) Res.drawable.ic_bell else Res.drawable.ic_setting
                    ),
                    contentDescription = null
                )
            }
        }
    }
}
