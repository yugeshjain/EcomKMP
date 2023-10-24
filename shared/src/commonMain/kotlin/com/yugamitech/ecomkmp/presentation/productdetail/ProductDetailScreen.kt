package com.yugamitech.ecomkmp.presentation.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yugamitech.ecomkmp.commonui.topAppBar.EcomTopAppBar

@Composable
fun ProductDetailScreen(
    titleText: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        content = {
            EcomTopAppBar(
                titleText = titleText,
                navigationIcon = Icons.Default.ArrowBack,
                actionIcon = Icons.Default.Share
            )
        }
    )
}
