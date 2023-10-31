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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yugamitech.ecomkmp.commonui.components.StarRatingIndicator
import com.yugamitech.ecomkmp.domain.model.ProductModel
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.button_light_gray
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.formatToDoubleDecimal
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
                    },
                    modifier = Modifier.weight(0.7f)
                )

                Text(
                    text = "View All",
                    style = MaterialTheme.typography.body1.copy(
                        color = black
                    ),
                    modifier = Modifier
                        .weight(0.3f)
                        .clickable(
                        onClick = onViewAllClick
                    ),
                    textAlign = TextAlign.End
                )
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
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
                            StarRatingIndicator(
                                modifier = Modifier.fillMaxWidth(),
                                ratingCount = 10
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
