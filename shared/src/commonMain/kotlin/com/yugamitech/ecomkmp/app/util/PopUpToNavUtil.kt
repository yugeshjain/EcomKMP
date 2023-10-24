package com.yugamitech.ecomkmp.app.util

import com.yugamitech.ecomkmp.navigation.HomeDestination
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo

fun popUpToHomeScreen(
    route: String,
    navigator: Navigator,
    launchSingleTop: Boolean = false
) {
    popUpToScreen(
        route = route,
        popUpToRoute = HomeDestination.route,
        navigator = navigator,
        launchSingleTop = launchSingleTop
    )
}

fun popUpToScreen(
    route: String,
    popUpToRoute: String,
    navigator: Navigator,
    launchSingleTop: Boolean = false
) {
    navigator.navigate(
        route = route,
        options = NavOptions(
            popUpTo = PopUpTo(popUpToRoute),
            launchSingleTop = launchSingleTop
        )
    )
}
