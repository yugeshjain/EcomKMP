package com.yugamitech.ecomkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform