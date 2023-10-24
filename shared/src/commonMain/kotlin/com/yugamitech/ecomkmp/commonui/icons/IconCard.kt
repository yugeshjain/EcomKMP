package com.yugamitech.ecomkmp.commonui.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.util.white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun IconCard(
    imageSrc: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    elevation: Dp = 1.dp,
    backgroundColor: Color = white,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    colorFilter: ColorFilter? = null
) {
    Card(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        modifier = modifier.size(size = size),
        elevation = elevation,
        backgroundColor = backgroundColor,
        content = {
            Image(
                painter = painterResource(res = imageSrc),
                contentDescription = contentDescription,
                modifier = Modifier
                    .padding(8.dp)
                    .size(size = size.minus(16.dp)),
                colorFilter = colorFilter
            )
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IconCard(
    icon: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    elevation: Dp = 1.dp,
    backgroundColor: Color = white,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Card(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        modifier = modifier.size(size = size),
        elevation = elevation,
        backgroundColor = backgroundColor,
        content = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier
                    .padding(8.dp)
                    .size(size = size.minus(16.dp)),
                tint = tint
            )
        }
    )
}
