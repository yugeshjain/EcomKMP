package com.yugamitech.ecomkmp.presentation.profile

import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.ProfileDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.profileGraph(
    navigator: Navigator,
    systemStatusBarPadding: Dp
) {
    scene(
        route = ProfileDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.PROFILE
            ProfileScreen(systemStatusBarPadding = systemStatusBarPadding)
        }
    )
}
