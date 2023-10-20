package com.yugamitech.ecomkmp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yugamitech.ecomkmp.domain.model.ProductModel
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.button_light_gray
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.formatToDoubleDecimal
import com.yugamitech.ecomkmp.util.star_yellow
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeItemsVerticalScroll(
    sectionTitle: String,
    sectionDescription: String,
    onViewAllClick: () -> Unit,
    itemList: List<ProductModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        content = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    content = {
                        Text(
                            text = sectionTitle,
                            style = MaterialTheme.typography.h3.copy(
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 2.sp
                            )
                        )
                        Text(
                            text = sectionDescription,
                            style = MaterialTheme.typography.body1.copy(
                                letterSpacing = 1.sp,
                                color = button_light_gray
                            )
                        )
                    }
                )

                Text(
                    text = "View All",
                    style = MaterialTheme.typography.body1.copy(
                        color = black
                    ),
                    modifier = Modifier.clickable(
                        onClick = onViewAllClick
                    )
                )
            }

            LazyRow(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                content = {
                    itemsIndexed(items = itemList) { index, product ->
                        ScrollableRowItem(
                            productModel = product,
                            onFavoriteClick = {},
                            modifier = Modifier
                                .padding(
                                    start = if (index == 0) 16.dp else 0.dp,
                                    end = 16.dp
                                )
                        )
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun ScrollableRowItem(
    productModel: ProductModel,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDiscountedProduct = productModel.discount != 0.0
    Column(
        modifier = modifier.fillMaxSize(),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .width(160.dp),
                content = {
                    Image(
                        painter = painterResource(res = productModel.image.first()),
                        contentDescription = productModel.name,
                        modifier = Modifier
                            .padding(bottom = 28.dp)
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(size = 16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    val bannerText = if (isDiscountedProduct) {
                        "-" + productModel.discount.toInt().toString() + "%"
                    } else {
                        "NEW"
                    }
                    if (isDiscountedProduct || productModel.isNewArrival){
                        Card(
                            modifier = Modifier.padding(8.dp),
                            shape = CircleShape,
                            backgroundColor = if (isDiscountedProduct) button_red else black,
                            content = {
                                Text(
                                    text = bannerText,
                                    style = MaterialTheme.typography.body2.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        color = white
                                    ),
                                    modifier = Modifier.padding(
                                        vertical = 4.dp,
                                        horizontal = 8.dp
                                    )
                                )
                            }
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                            .fillMaxSize()
                            .align(alignment = Alignment.BottomEnd),
                        contentAlignment = Alignment.BottomEnd,
                        content = {
                            Card(
                                shape = CircleShape,
                                modifier = Modifier.size(size = 36.dp),
                                elevation = 4.dp,
                                onClick = onFavoriteClick,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.FavoriteBorder,
                                        tint = button_light_gray,
                                        contentDescription = "Favorite Button",
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                            )
                        }
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxSize()
                            .align(alignment = Alignment.BottomStart),
                        contentAlignment = Alignment.BottomStart,
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.fillMaxWidth(),
                                content = {
                                    for (i in 0..4) {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Rating",
                                            tint = star_yellow,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }

                                    Text(
                                        text = "(${productModel.ratingCount})",
                                        style = MaterialTheme.typography.caption.copy(
                                            color = button_light_gray
                                        )
                                    )
                                }
                            )
                        }
                    )
                }
            )

            Text(
                text = productModel.brand,
                style = MaterialTheme.typography.body1.copy(
                    color = button_light_gray,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = productModel.name,
                style = MaterialTheme.typography.h6.copy(
                    color = black,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "$" + productModel.price.formatToDoubleDecimal(),
                    textDecoration = if (isDiscountedProduct) TextDecoration.LineThrough else null,
                    style = MaterialTheme.typography.body1.copy(
                        color = if (isDiscountedProduct) black else button_red,
                        fontWeight = if (isDiscountedProduct) FontWeight.Normal else FontWeight.SemiBold
                    )
                )
                if (isDiscountedProduct) {
                    val discountedPrice =
                        productModel.price - (productModel.price * (productModel.discount / 100))
                    Text(
                        text = "$" + discountedPrice.formatToDoubleDecimal(),
                        style = MaterialTheme.typography.body1.copy(
                            color = button_red,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    )
}

val fakeSaleProducts = listOf(
    ProductModel(
        id = "1",
        name = "Evening Dress",
        brand = "Dorothy Perkins",
        description = "",
        image = listOf("sale11.png"),
        price = 15.0,
        discount = 20.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "2",
        name = "Sport Dress",
        brand = "Sitlly",
        description = "",
        image = listOf("sale21.png"),
        price = 22.0,
        discount = 15.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "1",
        name = "Long Dress",
        brand = "ZARA",
        description = "",
        image = listOf("sale31.png"),
        price = 15.0,
        discount = 30.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
)

val fakeNewProducts = listOf(
    ProductModel(
        id = "1",
        name = "Party Dress",
        brand = "H&M",
        description = "",
        image = listOf("new11.png"),
        price = 15.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10,
        isNewArrival = true
    ),
    ProductModel(
        id = "2",
        name = "Denim Shirt",
        brand = "LIME",
        description = "",
        image = listOf("new21.png"),
        price = 22.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "1",
        name = "T-Shirt Sailing",
        brand = "Mango Boy",
        description = "",
        image = listOf("new31.png"),
        price = 15.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10,
        isNewArrival = true
    ),
)
