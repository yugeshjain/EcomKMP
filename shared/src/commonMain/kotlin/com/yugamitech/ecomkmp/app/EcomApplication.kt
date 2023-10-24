package com.yugamitech.ecomkmp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.app.di.koinModule
import com.yugamitech.ecomkmp.app.util.popUpToHomeScreen
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavBar
import com.yugamitech.ecomkmp.navigation.BagDestination
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
                    backgroundColor = Color.Transparent,
                    bottomBar = {
                        BottomNavBar(
                            navigateToHome = {
                                popUpToHomeScreen(
                                    route = HomeDestination.route,
                                    launchSingleTop = true,
                                    navigator = navigator
                                )
                            },
                            navigateToShop = {
                                popUpToHomeScreen(
                                    route = ShopDestination.route,
                                    navigator = navigator
                                )
                            },
                            navigateToBag = {
                                popUpToHomeScreen(
                                    route = BagDestination.route,
                                    navigator = navigator
                                )
                            },
                            navigateToFavorites = {
                                popUpToHomeScreen(
                                    route = FavoritesDestination.route,
                                    navigator = navigator
                                )
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
