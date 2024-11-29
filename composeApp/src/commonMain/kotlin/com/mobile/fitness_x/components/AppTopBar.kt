package com.mobile.fitness_x.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fitness_x.composeapp.generated.resources.Res
import fitness_x.composeapp.generated.resources.ic_bell
import fitness_x.composeapp.generated.resources.ic_setting
import org.jetbrains.compose.resources.painterResource
import theme.lavenderBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onClickNotification: () -> Unit = {},
    onClickSettings: () -> Unit = {},
    onClickBack: () -> Unit = {},
    isNotMainRoute: Boolean = false,
    isShowAvatar: Boolean = false,
    isShowIconEnd: Boolean = false,
    isNotification: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically, // Đảm bảo các phần tử cùng hàng được căn giữa theo chiều dọc
    ) {
        if (!isNotMainRoute) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = {
                        onClickBack.invoke()
                    }
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            // Nếu không hiển thị nút back, thêm khoảng trống để cân bằng layout
            Spacer(modifier = Modifier.size(24.dp))
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center // Đảm bảo Text nằm giữa hoàn toàn trong Box
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (isShowIconEnd) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = {
                        if (isNotification) onClickNotification() else onClickSettings()
                    })
                    .background(lavenderBlue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(
                        if (isNotification) Res.drawable.ic_bell else Res.drawable.ic_setting
                    ),
                    contentDescription = null
                )
            }
        } else {
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}

