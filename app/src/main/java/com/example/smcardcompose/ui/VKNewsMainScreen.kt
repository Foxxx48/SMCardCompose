package com.example.smcardcompose.ui


import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.smcardcompose.ui.theme.SMCardComposeTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
//                backgroundColor = MaterialTheme.colorScheme.background
            ) {
                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }

                val items =
                    listOf(
                        NavigationItem.Home,
                        NavigationItem.Favorite,
                        NavigationItem.Account
                    )
                items.forEachIndexed() { index, item ->
                    BottomNavigationItem(
                        selected = selectedItemPosition.value == index,
                        onClick = {selectedItemPosition.value = index},
                        icon = {
                            Icon(
                                item.icon, contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = item.titleResId),
//                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Green
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

