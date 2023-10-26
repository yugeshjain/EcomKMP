package com.yugamitech.ecomkmp.presentation.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.commonui.components.ScreenHeadingText
import com.yugamitech.ecomkmp.commonui.components.StarRatingIndicator
import com.yugamitech.ecomkmp.commonui.topAppBar.EcomTopAppBar
import com.yugamitech.ecomkmp.domain.model.CartItem
import com.yugamitech.ecomkmp.domain.model.ShoppingCategory
import com.yugamitech.ecomkmp.domain.model.fakeCart
import com.yugamitech.ecomkmp.domain.model.fakeCategories
import com.yugamitech.ecomkmp.presentation.bag.annotatedString
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.formatToDoubleDecimal
import com.yugamitech.ecomkmp.util.off_white_bg
import com.yugamitech.ecomkmp.util.text_light_gray
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun FavouriteScreen(
    systemStatusBarPadding: Dp
) {
    Column(
        modifier = Modifier
            .padding(top = systemStatusBarPadding)
            .fillMaxSize()
            .background(color = off_white_bg)
    ) {
        EcomTopAppBar(
            actionIcon = Icons.Default.Search,
            onActionIconClick = {},
            elevation = 0.dp,
            backgroundColor = off_white_bg
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            content = {
                ScreenHeadingText(title = "Favorites")
                FavoriteCategorySlider(
                    categories = fakeCategories + fakeCategories,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                FilterRow(modifier = Modifier.padding(vertical = 12.dp))

                val favoriteItems = fakeCart.cartItems + fakeCart.cartItems
                favoriteItems.forEach {
                    FavoriteListItem(favoriteItem = it)
                }
            }
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FavoriteListItem(
    favoriteItem: CartItem,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(vertical = 8.dp)
            .padding(start = 16.dp, end = 12.dp),
        contentAlignment = Alignment.BottomEnd,
        content = {
            Card(
                modifier = modifier
                    .padding(end = 4.dp, bottom = 12.dp)
                    .height(intrinsicSize = IntrinsicSize.Max)
                    .fillMaxWidth(),
                elevation = 4.dp,
                shape = RoundedCornerShape(size = 12.dp),
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Image(
                                painter = painterResource(res = favoriteItem.image),
                                contentDescription = favoriteItem.name,
                                modifier = Modifier
                                    .weight(0.4f)
                                    .clip(shape =
                                    RoundedCornerShape(
                                        topStart = 12.dp,
                                        bottomStart = 12.dp)
                                    ),
                                contentScale = ContentScale.FillWidth,
                            )

                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .weight(1f)
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = favoriteItem.brand,
                                    style = MaterialTheme.typography.subtitle2.copy(
                                        fontWeight = FontWeight.Normal,
                                        color = text_light_gray
                                    )
                                )
                                Text(
                                    text = favoriteItem.name,
                                    style = MaterialTheme.typography.h6.copy(
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                )

                                val colorText =
                                    annotatedString(primaryText = "Color: ", secondaryText = favoriteItem.color)
                                val sizeText =
                                    annotatedString(primaryText = "Size: ", secondaryText = favoriteItem.size)
                                Text(
                                    text = "$colorText    $sizeText"
                                )

                                FavoritePriceAndRating(
                                    price = 12.0,
                                    rating = 10,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp)
                                )
                            }
                        }
                    )
                }
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(color = button_red),
                content = {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(16.dp)
                    )
                }
            )
        }
    )
}

@Composable
fun FavoritePriceAndRating(
    price: Double,
    rating: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Text(
                text = "$${price.formatToDoubleDecimal()}"
            )

            StarRatingIndicator(
                ratingCount = rating,
                modifier = Modifier.padding(end = 32.dp)
            )
        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FilterRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .weight(0.25f)
            ) {
                Image(
                    painter = painterResource(res = "filtericon.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(16.dp)
                )

                Text(
                    text = "Filters",
                    style = MaterialTheme.typography.body2
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .weight(0.4f)
            ) {
                Image(
                    painter = painterResource(res = "pricefiltericon.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(16.dp)
                )

                Text(
                    text = "Price: lowest to high",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteCategorySlider(
    categories: List<ShoppingCategory>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp),
        content = {
            categories.forEach {
                Card(
                    onClick = {},
                    shape = CircleShape,
                    backgroundColor = black,
                    modifier = Modifier.padding(end = 16.dp),
                    content = {
                        Text(
                            text = it.categoryTitle,
                            style = MaterialTheme.typography.body2.copy(
                                color = white
                            ),
                            modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp)
                        )
                    }
                )
            }
        }
    )
}
