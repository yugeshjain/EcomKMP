package com.yugamitech.ecomkmp.commonui.topAppBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.util.black
import com.yugamitech.ecomkmp.util.white

@Composable
fun EcomTopAppBar(
    modifier: Modifier = Modifier,
    titleText: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigationIconClick: () -> Unit = {},
    actionIcon: ImageVector? = null,
    onActionIconClick: () -> Unit = {},
    elevation: Dp = 4.dp,
    backgroundColor: Color = white
) {
    Card(
        backgroundColor = backgroundColor,
        modifier = modifier.fillMaxWidth(),
        elevation = elevation,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                content = {
                    titleText?.let { nnTitleText ->
                        Text(
                            text = nnTitleText,
                            style = MaterialTheme.typography.body1.copy(
                                color = black,
                                fontWeight = FontWeight.ExtraBold
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        navigationIcon?.let { nnNavigationIcon ->
                            Icon(
                                imageVector = nnNavigationIcon,
                                contentDescription = "Navigation Icon",
                                modifier = Modifier.clickable(
                                    onClick = onNavigationIconClick
                                )
                            )
                        } ?: run {
                            Box(modifier = Modifier.size(16.dp))
                        }

                        actionIcon?.let { nnActionIcon ->
                            Icon(
                                imageVector = nnActionIcon,
                                contentDescription = "Action Icon",
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .clickable(onClick = onActionIconClick)
                            )
                        }
                    }
                }
            )
        }
    )
}
