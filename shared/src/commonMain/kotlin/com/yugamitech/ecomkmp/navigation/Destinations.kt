package com.yugamitech.ecomkmp.navigation

object HomeDestination : TopLevelDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
    override val selectedIcon: String = "bottomnavicons/homeselected.png"
    override val unselectedIcon: String = "bottomnavicons/homeunselected.png"
    override val iconTextId: String = "Home"
    override val titleTextId: String = "Home"
}

object ShopDestination : TopLevelDestination {
    override val route: String = "shop_route"
    override val destination: String = "shop_destination"
    override val selectedIcon: String = "bottomnavicons/shopselected.png"
    override val unselectedIcon: String = "bottomnavicons/shopunselected.png"
    override val iconTextId: String = "Shop"
    override val titleTextId: String = "Shop"
}

object BagDestination : TopLevelDestination {
    override val route: String = "bag_route"
    override val destination: String = "bag_destination"
    override val selectedIcon: String = "bottomnavicons/bagselected.png"
    override val unselectedIcon: String = "bottomnavicons/bagunselected.png"
    override val iconTextId: String = "Bag"
    override val titleTextId: String = "Bag"
}

object FavoritesDestination : TopLevelDestination {
    override val route: String = "favorites_route"
    override val destination: String = "favorites_destination"
    override val selectedIcon: String = "bottomnavicons/favoriteselected.png"
    override val unselectedIcon: String = "bottomnavicons/favoriteunselected.png"
    override val iconTextId: String = "Favorites"
    override val titleTextId: String = "Favorites"
}

object ProfileDestination : TopLevelDestination {
    override val route: String = "profile_route"
    override val destination: String = "profile_destination"
    override val selectedIcon: String = "bottomnavicons/profileselected.png"
    override val unselectedIcon: String = "bottomnavicons/profileunselected.png"
    override val iconTextId: String = "Profile"
    override val titleTextId: String = "Profile"
}

object HelpCenterDestination : EcomNavDestination {
    override val route = "help_center_route"
    override val destination = "help_center_destination"
}
