package com.yugamitech.ecomkmp.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.navigation.HomeDestination
import com.yugamitech.ecomkmp.presentation.bag.bagGraph
import com.yugamitech.ecomkmp.presentation.favorites.favouritesGraph
import com.yugamitech.ecomkmp.presentation.home.homeGraph
import com.yugamitech.ecomkmp.presentation.profile.profileGraph
import com.yugamitech.ecomkmp.presentation.shop.shopGraph
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun EcomNavHost(
    ecomNavigator: Navigator,
    systemStatusBarPadding: Dp
) {
    NavHost(
        navigator = ecomNavigator,
        initialRoute = HomeDestination.route,
    ) {
        homeGraph(navigator = ecomNavigator)
        favouritesGraph(
            navigator = ecomNavigator,
            systemStatusBarPadding = systemStatusBarPadding
        )
        bagGraph(
            navigator = ecomNavigator,
            systemStatusBarPadding = systemStatusBarPadding
        )
        shopGraph(
            navigator = ecomNavigator,
            systemStatusBarPadding = systemStatusBarPadding
        )
        profileGraph(
            navigator = ecomNavigator,
            systemStatusBarPadding = systemStatusBarPadding
        )
    }
}
