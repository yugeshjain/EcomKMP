package com.yugamitech.ecomkmp.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FavouriteScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Box(
                modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Red)
                )
            }
        }
    )
}
