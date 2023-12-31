package com.yugamitech.ecomkmp.navigation

import androidx.compose.runtime.Immutable

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
@Immutable
interface TopLevelDestination : EcomNavDestination {
    override val route: String
    override val destination: String
    val selectedIcon: String
    val unselectedIcon: String
    val iconTextId: String
    val titleTextId: String
}
