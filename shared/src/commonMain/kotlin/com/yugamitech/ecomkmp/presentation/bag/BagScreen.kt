package com.yugamitech.ecomkmp.presentation.bag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yugamitech.ecomkmp.commonui.components.ScreenHeadingText
import com.yugamitech.ecomkmp.commonui.icons.IconCard
import com.yugamitech.ecomkmp.commonui.topAppBar.EcomTopAppBar
import com.yugamitech.ecomkmp.domain.model.CartItem
import com.yugamitech.ecomkmp.domain.model.fakeCart
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.dark_gray
import com.yugamitech.ecomkmp.util.formatToDoubleDecimal
import com.yugamitech.ecomkmp.util.off_white_bg
import com.yugamitech.ecomkmp.util.text_light_gray
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun BagScreen(
    systemStatusBarPadding: Dp
) {
    val items = fakeCart.cartItems + fakeCart.cartItems
    var totalAmount = 0.0
    LaunchedEffect(Unit) {
        items.forEach {
            totalAmount += it.price.times(it.qty)
        }
    }
    Column(
        modifier = Modifier.padding(top = systemStatusBarPadding).fillMaxSize()
            .background(color = off_white_bg),
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            EcomTopAppBar(
                actionIcon = Icons.Default.Search,
                onActionIconClick = {},
                elevation = 0.dp,
                backgroundColor = off_white_bg
            )
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ScreenHeadingText(title = "My Bag")
                items.forEach { fakeCartItem ->
                    cartItemComposable(
                        cartItem = fakeCartItem
                    )
                }
            }
        }
        CheckoutButton(totalAmount = totalAmount, onCheckoutClick = {})
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun cartItemComposable(
    cartItem: CartItem, modifier: Modifier = Modifier
) {
    val qty = remember { mutableStateOf(cartItem.qty) }
    Card(modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        .height(intrinsicSize = IntrinsicSize.Max),
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp),
        content = {
            Row(modifier = Modifier.fillMaxWidth(), content = {
                Image(
                    painter = painterResource(res = cartItem.image),
                    contentDescription = cartItem.name,
                    modifier = Modifier.weight(0.35f).clip(
                        shape = RoundedCornerShape(
                            topStart = 12.dp, bottomStart = 12.dp
                        )
                    ),
                    contentScale = ContentScale.FillWidth,
                )

                Column(
                    modifier = Modifier.padding(8.dp).weight(1f).fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = cartItem.name, style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )

                    val colorText =
                        annotatedString(primaryText = "Color: ", secondaryText = cartItem.color)
                    val sizeText =
                        annotatedString(primaryText = "Size: ", secondaryText = cartItem.size)
                    Text(
                        text = "$colorText    $sizeText"
                    )

                    qtyMeter(
                        price = cartItem.price.times(cartItem.qty), qty = qty
                    )
                }
            })
        })
}

@Composable
fun qtyMeter(
    price: Double, qty: MutableState<Int>, modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(top = 8.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Row(modifier = modifier.padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                content = {
                    IconCard(
                        imageSrc = "minus.png", contentDescription = null, onClick = {
                            if (qty.value > 1) qty.value -= 1
                        }, colorFilter = ColorFilter.tint(color = dark_gray)
                    )

                    Text(
                        text = qty.value.toString(), modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    IconCard(
                        imageSrc = "plus.png", contentDescription = null, onClick = {
                            if (qty.value >= 1) qty.value += 1
                        }, colorFilter = ColorFilter.tint(color = dark_gray)
                    )
                })

            Text(
                text = "$${price.formatToDoubleDecimal()}",
                style = MaterialTheme.typography.body1.copy(
                    color = black, fontWeight = FontWeight.Normal
                )
            )
        })
}

@Composable
fun CheckoutButton(
    totalAmount: Double, onCheckoutClick: () -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().background(off_white_bg), content = {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            content = {
                Text(
                    text = "Total amount:", style = MaterialTheme.typography.body1.copy(
                        color = text_light_gray
                    )
                )
                Text(
                    text = "$${totalAmount.formatToDoubleDecimal()}",
                    style = MaterialTheme.typography.body1.copy(
                        color = black, fontWeight = FontWeight.SemiBold
                    )
                )
            })

        Button(
            onClick = onCheckoutClick,
            content = {
                Text(
                    text = "CHECK OUT", style = MaterialTheme.typography.body1.copy(
                        color = white
                    ), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                )
            },
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = button_red)
        )
    })
}

fun annotatedString(
    primaryText: String,
    secondaryText: String,
    primaryTextColor: Color = text_light_gray,
    secondaryTextColor: Color = black
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = primaryTextColor, fontSize = 16.sp, fontWeight = FontWeight.Light
        ), block = { append(primaryText) })
        withStyle(style = SpanStyle(
            color = secondaryTextColor, fontSize = 16.sp, fontWeight = FontWeight.Light
        ), block = { append(secondaryText) })
    }
}
