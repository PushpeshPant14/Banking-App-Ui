package com.example.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingappui.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title="Home",
        icon=Icons.Rounded.Home
    ),
    BottomNavigation(
        "Wallet",
        Icons.Rounded.Wallet
    ),
    BottomNavigation(
        "Notification",
        Icons.Rounded.Notifications
    ),
    BottomNavigation(
        "Account",
        Icons.Rounded.AccountCircle
    )
)
@Preview
@Composable
fun BottomNavBar(){
    NavigationBar {
        var isSelected by remember {
            mutableStateOf(0)
        }
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index==isSelected,
                    onClick = {
                          isSelected=index
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }
}