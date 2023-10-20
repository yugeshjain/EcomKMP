package com.yugamitech.ecomkmp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SectionBanner(
    sectionTitle: String,
    bgImage: String,
    modifier: Modifier = Modifier,
    titleTextColor: Color = white
) {
    Box(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomStart,
        content = {
            Image(
                painter = painterResource(bgImage),
                contentDescription = sectionTitle,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = sectionTitle,
                style = MaterialTheme.typography.h3.copy(
                    color = titleTextColor,
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier.padding(
                    vertical = 24.dp,
                    horizontal = 12.dp
                )
            )
        }
    )
}
