package com.example.smcardcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smcardcompose.ui.theme.SMCardComposeTheme

class Example {

    @Preview
    @Composable
    fun Test() {
        SMCardComposeTheme(
            darkTheme = true,
            dynamicColor = false
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Example2()
            }
        }
    }


    @Composable
    fun Example1() {
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Hello World")
        }
    }

    @Composable
    fun Example2() {
        TextField(
            value = "Value", onValueChange = {},
            label = {
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = "Label"
                )
            })

    }

    @Composable
    fun Example3() {
        AlertDialog(onDismissRequest = {},
            title = {
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = "Do you want to delete this file?",
                    fontSize = 18.sp
                )
            },
            text = {
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = "Are you sure?"
                )
            },
            confirmButton = {
                TextButton(onClick = {}) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {}) {
                    Text(text = "Dismiss")
                }
            }

        )

    }
}