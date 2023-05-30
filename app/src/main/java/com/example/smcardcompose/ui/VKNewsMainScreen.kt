package com.example.smcardcompose.ui


import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.smcardcompose.ui.theme.SMCardComposeTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colorScheme.background
            ) {
                val selectedItemPosition = 0
                val items =
                    listOf(
                        NavigationItem.Home,
                        NavigationItem.Favorite,
                        NavigationItem.Account
                    )
                items.forEachIndexed() { index, item ->
                    BottomNavigationItem(
                        selected = selectedItemPosition == index,
                        onClick = {},
                        icon = {
                            Icon(
                                item.icon, contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = item.titleResId),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.secondary,
                        unselectedContentColor = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }

        },

        ) {

    }


}

@Preview
@Composable
fun PreviewLightTheme() {
    SMCardComposeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {

        MainScreen()
    }
}

@Preview
@Composable
fun PreviewDarkTheme() {
    SMCardComposeTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        MainScreen()

    }
}

