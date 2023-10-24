package com.yugamitech.ecomkmp.app.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.yugamitech.ecomkmp.commonui.bottombar.BottomNavOptions

var currentSelectedBottomOption: MutableState<BottomNavOptions?> =  mutableStateOf(null)
val isBottomNavVisible: Boolean? = null
