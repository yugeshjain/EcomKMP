package com.yugamitech.ecomkmp.presentation.shop

import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.ShopDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.shopGraph(
    navigator: Navigator,
    systemStatusBarPadding: Dp
) {
    scene(
        route = ShopDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.SHOP
            ShopScreen(systemStatusBarPadding = systemStatusBarPadding)
        }
    )
}
