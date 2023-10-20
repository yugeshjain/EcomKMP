package com.yugamitech.ecomkmp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun PageTopSaleCard(
    onCheckClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource("hometopbg.png"),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Fashion \nsale",
                style = MaterialTheme.typography.h2.copy(
                    fontWeight = FontWeight.Black,
                    color = white,
                    letterSpacing = 2.sp,
                    lineHeight = 52.sp
                )
            )

            Button(
                onClick = onCheckClick,
                content = {
                    Text(
                        text = "Check",
                        style = MaterialTheme.typography.body1.copy(
                            color = white,
                            letterSpacing = 1.sp
                        ),
                        modifier = Modifier.fillMaxWidth(0.4f),
                        textAlign = TextAlign.Center
                    )
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = button_red),
                shape = CircleShape
            )
        }
    }
}
