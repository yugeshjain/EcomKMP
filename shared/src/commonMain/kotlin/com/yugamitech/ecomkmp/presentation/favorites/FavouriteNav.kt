package com.yugamitech.ecomkmp.presentation.favorites

import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.app.util.currentSelectedBottomOption
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions
import com.yugamitech.ecomkmp.navigation.FavoritesDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.favouritesGraph(
    navigator: Navigator,
    systemStatusBarPadding: Dp
) {
    scene(
        route = FavoritesDestination.route,
        content = {
            currentSelectedBottomOption.value = BottomNavOptions.FAVORITE
            FavouriteScreen(systemStatusBarPadding = systemStatusBarPadding)
        }
    )
}
