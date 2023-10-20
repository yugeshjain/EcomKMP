package com.yugamitech.ecomkmp.util

import kotlin.math.abs

fun Double.formatToDoubleDecimal(): String {
    val intValue = (this * 100).toInt()
    return "${intValue / 100}.${abs(intValue % 100).toString().padStart(2, '0')}"
}
