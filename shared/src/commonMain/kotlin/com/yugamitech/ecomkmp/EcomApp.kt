package com.yugamitech.ecomkmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.app.EcomApplication

@Composable
fun EcomApp(systemStatusBarPadding: Dp = 52.dp) {
    EcomApplication(systemStatusBarPadding = systemStatusBarPadding)
}
