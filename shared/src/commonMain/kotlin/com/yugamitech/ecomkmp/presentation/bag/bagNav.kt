package com.yugamitech.ecomkmp.presentation.bag

import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.BagDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.bagGraph(
    navigator: Navigator,
    systemStatusBarPadding: Dp
) {
    scene(
        route = BagDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.BAG
            BagScreen(systemStatusBarPadding = systemStatusBarPadding)
        }
    )
}
