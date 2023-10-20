package com.yugamitech.ecomkmp.presentation.shop.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.util.button_red
import com.yugamitech.ecomkmp.util.white

@Composable
fun SaleBanner(
    bannerTitle: String,
    modifier: Modifier = Modifier,
    bannerDescription: String? = null,
    bannerTextColor: Color = white,
    bannerBg: Color = button_red,
) {
    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(size = 12.dp),
        backgroundColor = bannerBg,
        content = {
            Column(
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(
                        text = bannerTitle,
                        style = MaterialTheme.typography.h5.copy(
                            color = bannerTextColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    bannerDescription?.let { nnBannerDescription ->
                        Text(
                            text = nnBannerDescription,
                            style = MaterialTheme.typography.body1.copy(
                                color = bannerTextColor,
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            )
        }
    )
}
