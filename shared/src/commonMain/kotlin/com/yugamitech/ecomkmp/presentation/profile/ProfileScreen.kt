package com.yugamitech.ecomkmp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yugamitech.ecomkmp.commonui.components.ScreenHeadingText
import com.yugamitech.ecomkmp.commonui.topAppBar.EcomTopAppBar
import com.yugamitech.ecomkmp.domain.model.UserModel
import com.yugamitech.ecomkmp.domain.model.fakeProfile
import com.yugamitech.ecomkmp.domain.model.profileOptions
import com.yugamitech.ecomkmp.util.button_light_gray
import com.yugamitech.ecomkmp.util.off_white_bg
import com.yugamitech.ecomkmp.util.text_light_gray
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun ProfileScreen(
    systemStatusBarPadding: Dp
) {
    Column(
        modifier = Modifier
            .padding(top = systemStatusBarPadding)
            .fillMaxSize()
            .background(color = off_white_bg),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        content = {
            EcomTopAppBar(
                actionIcon = Icons.Default.Search,
                onActionIconClick = {},
                elevation = 0.dp,
                backgroundColor = off_white_bg
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                content = {
                    ScreenHeadingText(title = "My Profile")
                    ProfileCard(profileData = fakeProfile)

                    Spacer(modifier = Modifier.size(8.dp))
                    profileOptions.forEach { options ->
                        ProfileOptions(
                            titleText = options.first,
                            descriptionText = options.second,
                            onClick = {}
                        )
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ProfileCard(
    profileData: UserModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(res = profileData.profilePic ?: "profileplaceholder.png"),
            contentDescription = "profilepic",
            modifier = Modifier
                .padding(end = 16.dp)
                .clip(shape = CircleShape)
                .size(64.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
            content = {
                Text(
                    text = profileData.firstName + " " + profileData.lastName,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = profileData.email,
                    style = MaterialTheme.typography.body2.copy(
                        color = text_light_gray
                    )
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@Composable
private fun ProfileOptions(
    titleText: String,
    descriptionText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        backgroundColor = off_white_bg,
        elevation = 0.dp,
        onClick = onClick,
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            content = {
                                Text(
                                    text = titleText,
                                    style = MaterialTheme.typography.body1.copy(
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                Text(
                                    text = descriptionText,
                                    style = MaterialTheme.typography.caption.copy(
                                        color = text_light_gray
                                    ),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        )


                        Image(
                            painter = painterResource(res = "arrowforward.png"),
                            contentDescription = titleText,
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(color = button_light_gray)

                        )
                    }

                    Divider(
                        color = text_light_gray,
                        thickness = 0.3.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        }
    )
}
