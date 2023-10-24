package com.yugamitech.ecomkmp.presentation.shop

import androidx.compose.animation.EnterTransition
import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.ShopDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.shopGraph(
    navigator: Navigator,
    systemStatusBarPadding: Dp
) {
    scene(
        navTransition = NavTransition(EnterTransition.None),
        route = ShopDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.SHOP
            ShopScreen(systemStatusBarPadding = systemStatusBarPadding)
        }
    )
}
