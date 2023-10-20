package com.yugamitech.ecomkmp.domain.model

data class ProductModel(
    val id: String,
    val name: String,
    val brand: String,
    val description: String? = null,
    val image: List<String> = listOf("verticalplaceholderimage.png", "verticalplaceholderimage.png"),
    val price: Double,
    val discount: Double = 0.0,
    val isFavorite: Boolean = false,
    val rating: Double = 0.0,
    val ratingCount: Int = 0,
    val isNewArrival: Boolean = false
)
