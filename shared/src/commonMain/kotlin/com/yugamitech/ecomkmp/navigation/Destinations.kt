package com.yugamitech.ecomkmp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


object HomeDestination : TopLevelDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
    override val selectedIcon: ImageVector = Icons.Filled.Home
    override val unselectedIcon: ImageVector = Icons.Outlined.Home
    override val iconTextId: String = "Home"
    override val titleTextId: String = "Home"
}

object ShopDestination : TopLevelDestination {
    override val route: String = "shop_route"
    override val destination: String = "shop_destination"
    override val selectedIcon: ImageVector = Icons.Filled.List
    override val unselectedIcon: ImageVector = Icons.Outlined.List
    override val iconTextId: String = "Shop"
    override val titleTextId: String = "Shop"
}

object BagDestination : TopLevelDestination {
    override val route: String = "bag_route"
    override val destination: String = "bag_destination"
    override val selectedIcon: ImageVector = Icons.Filled.ShoppingCart
    override val unselectedIcon: ImageVector = Icons.Outlined.ShoppingCart
    override val iconTextId: String = "Bag"
    override val titleTextId: String = "Bag"
}

object FavoritesDestination : TopLevelDestination {
    override val route: String = "favorites_route"
    override val destination: String = "favorites_destination"
    override val selectedIcon: ImageVector = Icons.Filled.Favorite
    override val unselectedIcon: ImageVector = Icons.Outlined.FavoriteBorder
    override val iconTextId: String = "Favorites"
    override val titleTextId: String = "Favorites"
}

object ProfileDestination : TopLevelDestination {
    override val route: String = "profile_route"
    override val destination: String = "profile_destination"
    override val selectedIcon: ImageVector = Icons.Filled.Person
    override val unselectedIcon: ImageVector = Icons.Outlined.Person
    override val iconTextId: String = "Profile"
    override val titleTextId: String = "Profile"
}

object HelpCenterDestination : EcomNavDestination {
    override val route = "help_center_route"
    override val destination = "help_center_destination"
}
