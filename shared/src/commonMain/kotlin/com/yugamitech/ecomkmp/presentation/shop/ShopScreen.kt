package com.yugamitech.ecomkmp.presentation.shop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.yugamitech.ecomkmp.commonui.topAppBar.EcomTopAppBar
import com.yugamitech.ecomkmp.presentation.shop.components.CategoryCard
import com.yugamitech.ecomkmp.presentation.shop.components.SaleBanner
import com.yugamitech.ecomkmp.presentation.shop.components.fakeCategories
import com.yugamitech.ecomkmp.util.off_white_bg

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShopScreen(
    systemStatusBarPadding: Dp
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = systemStatusBarPadding)
            .background(color = off_white_bg),
        content = {
            stickyHeader(
                content = {
                    EcomTopAppBar(
                        titleText = "Categories",
                        actionIcon = Icons.Default.Search,
                        navigationIcon = Icons.Default.ArrowBack
                    )
                }
            )
            item {
                SaleBanner(
                    bannerTitle = "SUMMER SALES",
                    bannerDescription = "Up to 50% off"
                )
            }

            itemsIndexed(items = fakeCategories + fakeCategories){ index, category ->
                CategoryCard(
                    shoppingCategory = category
                )
            }
        }
    )
}
