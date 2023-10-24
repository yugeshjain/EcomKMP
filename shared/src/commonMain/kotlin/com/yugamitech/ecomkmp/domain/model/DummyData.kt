package com.yugamitech.ecomkmp.domain.model

data class ShoppingCategory(
    val categoryTitle: String,
    val categoryImage: String,
)

val fakeCategories = listOf(
    ShoppingCategory(
        categoryTitle = "New",
        categoryImage = "newcategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Clothes",
        categoryImage = "clothescategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Shoes",
        categoryImage = "shoescategory.png"
    ),
    ShoppingCategory(
        categoryTitle = "Accesories",
        categoryImage = "accesoriescategory.png"
    ),
)


val fakeSaleProducts = listOf(
    ProductModel(
        id = "1",
        name = "Evening Dress",
        brand = "Dorothy Perkins",
        description = "",
        image = listOf("sale11.png"),
        price = 15.0,
        discount = 20.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "2",
        name = "Sport Dress",
        brand = "Sitlly",
        description = "",
        image = listOf("sale21.png"),
        price = 22.0,
        discount = 15.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "1",
        name = "Long Dress",
        brand = "ZARA",
        description = "",
        image = listOf("sale31.png"),
        price = 15.0,
        discount = 30.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
)

val fakeNewProducts = listOf(
    ProductModel(
        id = "1",
        name = "Party Dress",
        brand = "H&M",
        description = "",
        image = listOf("new11.png"),
        price = 15.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10,
        isNewArrival = true
    ),
    ProductModel(
        id = "2",
        name = "Denim Shirt",
        brand = "LIME",
        description = "",
        image = listOf("new21.png"),
        price = 22.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10
    ),
    ProductModel(
        id = "1",
        name = "T-Shirt Sailing",
        brand = "Mango Boy",
        description = "",
        image = listOf("new31.png"),
        price = 15.0,
        discount = 0.0,
        isFavorite = false,
        rating = 5.0,
        ratingCount = 10,
        isNewArrival = true
    ),
)

val fakeCart = Cart(
    cartItems = listOf(
        CartItem(
            id = "1",
            name = "T-Shirt Sailing",
            brand = "Mango Boy",
            image = "new11.png",
            price = 15.0,
            color = "Black",
            qty = 1,
            size = "L"
        ),
        CartItem(
            id = "2",
            name = "Denim Shirt",
            brand = "LIME",
            image = "new21.png",
            price = 27.0,
            color = "White",
            qty = 2,
            size = "XL"
        ),
        CartItem(
            id = "3",
            name = "T-Shirt",
            brand = "NEW",
            image = "new31.png",
            price = 12.0,
            color = "Blue",
            qty = 1,
            size = "M"
        )
    )
)