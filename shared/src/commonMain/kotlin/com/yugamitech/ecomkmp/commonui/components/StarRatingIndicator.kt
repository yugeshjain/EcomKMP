package com.yugamitech.ecomkmp.commonui.components

import androidx.annotation.IntRange
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.util.button_light_gray
import com.yugamitech.ecomkmp.util.star_yellow

@Composable
fun StarRatingIndicator(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    @IntRange(from = 0, to = 5)
    rating: Int = 5,
    ratingCount: Int = 0
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = onClick != {}
            ),
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
                text = "($ratingCount)",
                style = MaterialTheme.typography.caption.copy(
                    color = button_light_gray
                )
            )
        }
    )
}
