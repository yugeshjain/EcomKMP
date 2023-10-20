package com.yugamitech.ecomkmp.presentation.favorites

import com.yugamitech.ecomkmp.navigation.FavoritesDestination
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.favouritesGraph(
    navigator: Navigator
) {
    scene(
        route = FavoritesDestination.route,
        content = {
            FavouriteScreen()
        }
    )
}
