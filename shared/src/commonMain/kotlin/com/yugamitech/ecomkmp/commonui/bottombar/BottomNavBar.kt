package com.yugamitech.ecomkmp.commonui.bottombar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.navigation.BagDestination
import com.yugamitech.ecomkmp.navigation.FavoritesDestination
import com.yugamitech.ecomkmp.navigation.HomeDestination
import com.yugamitech.ecomkmp.navigation.ProfileDestination
import com.yugamitech.ecomkmp.navigation.ShopDestination
import com.yugamitech.ecomkmp.util.button_light_gray
import com.yugamitech.ecomkmp.util.button_red

@Composable
fun BottomNavBar(
    navigateToHome: () -> Unit,
    navigateToShop: () -> Unit,
    navigateToBag: () -> Unit,
    navigateToFavorites: () -> Unit,
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            selectedItem = index
                            when (bottomNavItem.title) {
                                HomeDestination.titleTextId -> navigateToHome()
                                ShopDestination.titleTextId -> navigateToShop()
                                BagDestination.titleTextId -> navigateToBag()
                                FavoritesDestination.titleTextId -> navigateToFavorites()
                                ProfileDestination.titleTextId -> navigateToProfile()
                            }
                        }
                    )
            ) {
                val itemColor = if (index == selectedItem) button_red else button_light_gray
                Icon(
                    imageVector = if (index == selectedItem) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon,
                    contentDescription = bottomNavItem.title,
                    modifier = Modifier.size(24.dp),
                    tint = itemColor
                )

                Text(
                    text = bottomNavItem.title,
                    style = MaterialTheme.typography.body2.copy(
                        color = itemColor
                    )
                )
            }
        }
    }
}

private data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

private val bottomNavItems = listOf(
    BottomNavItem(
        title = HomeDestination.titleTextId,
        selectedIcon = HomeDestination.selectedIcon,
        unselectedIcon = HomeDestination.unselectedIcon
    ),
    BottomNavItem(
        title = ShopDestination.titleTextId,
        selectedIcon = ShopDestination.selectedIcon,
        unselectedIcon = ShopDestination.unselectedIcon
    ),
    BottomNavItem(
        title = BagDestination.titleTextId,
        selectedIcon = BagDestination.selectedIcon,
        unselectedIcon = BagDestination.unselectedIcon
    ),
    BottomNavItem(
        title = FavoritesDestination.titleTextId,
        selectedIcon = FavoritesDestination.selectedIcon,
        unselectedIcon = FavoritesDestination.unselectedIcon
    ),
    BottomNavItem(
        title = ProfileDestination.titleTextId,
        selectedIcon = ProfileDestination.selectedIcon,
        unselectedIcon = ProfileDestination.unselectedIcon
    ),
)
