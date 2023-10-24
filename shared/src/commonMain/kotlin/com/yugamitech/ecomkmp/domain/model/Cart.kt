package com.yugamitech.ecomkmp.domain.model

data class Cart(
    val cartItems: List<CartItem>
)

data class CartItem(
    val id: String,
    val name: String,
    val brand: String,
    val color: String,
    val qty: Int,
    val size: String,
    val price: Double,
    val image: String
)
