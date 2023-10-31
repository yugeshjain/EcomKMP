package com.yugamitech.ecomkmp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yugamitech.ecomkmp.domain.model.fakeNewProducts
import com.yugamitech.ecomkmp.domain.model.fakeSaleProducts
import com.yugamitech.ecomkmp.presentation.home.components.HomeItemsVerticalScroll
import com.yugamitech.ecomkmp.presentation.home.components.PageTopSaleCard
import com.yugamitech.ecomkmp.presentation.home.components.SectionBanner
import com.yugamitech.ecomkmp.util.off_white_bg

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .background(color = off_white_bg)
            .fillMaxSize(),
        content = {
            item {
                PageTopSaleCard(
                    onCheckClick = {}
                )
            }
            item {
                HomeItemsVerticalScroll(
                    sectionTitle = "New",
                    sectionDescription = "You've never seen it before!",
                    onViewAllClick = {},
                    itemList = fakeNewProducts
                )
                HomeItemsVerticalScroll(
                    sectionTitle = "Sale",
                    sectionDescription = "Super summer sale",
                    onViewAllClick = {},
                    itemList = fakeSaleProducts
                )
            }
            item {
                SectionBanner(
                    sectionTitle = "Street clothes",
                    bgImage = "sectionbanner1.png"
                )
            }
            item {
                HomeItemsVerticalScroll(
                    sectionTitle = "New",
                    sectionDescription = "You've never seen it before!",
                    onViewAllClick = {},
                    itemList = fakeNewProducts
                )
                HomeItemsVerticalScroll(
                    sectionTitle = "Sale",
                    sectionDescription = "Super summer sale",
                    onViewAllClick = {},
                    itemList = fakeSaleProducts
                )
            }
        }
    )
}
