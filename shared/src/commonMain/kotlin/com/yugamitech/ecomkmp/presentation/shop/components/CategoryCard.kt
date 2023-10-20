package com.yugamitech.ecomkmp.presentation.shop.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CategoryCard(
    shoppingCategory: ShoppingCategory,
    modifier: Modifier = Modifier,
    backgroundColor: Color = white,
    titleColor: Color = black
) {
    Card(
        modifier = modifier
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = backgroundColor,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    Text(
                        text = shoppingCategory.categoryTitle,
                        style = MaterialTheme.typography.h5.copy(
                            color = titleColor,
                            letterSpacing = 1.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)
                    )

                    Image(
                        painter = painterResource(res = shoppingCategory.categoryImage),
                        contentDescription = shoppingCategory.categoryTitle,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
                            .weight(1f)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            )
        }
    )
}

data class ShoppingCategory(
    val categoryTitle: String,
    val categoryImage: String,
)

val fakeCategories = listOf(
    ShoppingCategory(
        categoryTitle = "New",
        categoryImage = "newcategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Clothes",
        categoryImage = "clothescategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Shoes",
        categoryImage = "shoescategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Accesories",
        categoryImage = "accesoriescategory.png"
    ),
)
