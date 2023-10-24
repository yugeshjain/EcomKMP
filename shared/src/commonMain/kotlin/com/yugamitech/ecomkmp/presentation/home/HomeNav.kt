package com.yugamitech.ecomkmp.presentation.home

import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.HomeDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.homeGraph(
    navigator: Navigator
) {
    scene(
        route = HomeDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.HOME
            HomeScreen()
        }
    )
}
