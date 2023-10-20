package com.yugamitech.ecomkmp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.app.di.koinModule
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavBar
import com.yugamitech.ecomkmp.navigation.FavoritesDestination
import com.yugamitech.ecomkmp.navigation.HomeDestination
import com.yugamitech.ecomkmp.navigation.ShopDestination
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinApplication

@Composable
fun EcomApplication(
    systemStatusBarPadding: Dp
) {
    KoinApplication(
        application = {
            modules(
                koinModule()
            )
        },
        content = {
            val navigator = rememberNavigator()
            MaterialTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBar(
                            navigateToHome = {
                                navigator.navigate(HomeDestination.route)
                            },
                            navigateToShop = {
                                navigator.navigate(ShopDestination.route)
                            },
                            navigateToBag = {},
                            navigateToFavorites = {
                                navigator.navigate(FavoritesDestination.route)
                            },
                            navigateToProfile = {}
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(
                        modifier = Modifier
                            .padding(bottom = 64.dp)
                            .fillMaxSize(),
                        content = {
                            EcomNavHost(
                                ecomNavigator = navigator,
                                systemStatusBarPadding = systemStatusBarPadding
                            )
                        }
                    )
                }
            }
        }
    )
}
