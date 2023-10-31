package com.yugamitech.ecomkmp.domain.model

data class UserModel(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val email: String,
    val phone: String,
    val address: List<UserAddress>? = null,
    val profilePic: String? = null
) {
    data class UserAddress(
        val houseNumber: String,
        val street: String,
        val city: String,
        val state: String,
        val country: String,
        val pinCode: String,
        val landmark: String?
    )
}
