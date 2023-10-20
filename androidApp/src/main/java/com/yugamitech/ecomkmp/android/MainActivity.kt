package com.yugamitech.ecomkmp.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.yugamitech.ecomkmp.EcomApp
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

class MainActivity : PreComposeActivity() {
    @SuppressLint("InternalInsetResource", "DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Removes System Bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Calculating Status Bar Height
            val density = LocalDensity.current.density
            val statusBarHeight = with(LocalView.current) {
                val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
                val statusBarHeightPx = if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
                (statusBarHeightPx / density).dp
            }

            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EcomApp(systemStatusBarPadding = statusBarHeight)
                }
            }
        }
    }
}
