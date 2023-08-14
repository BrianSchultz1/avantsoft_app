package com.example.avantsoft.core


class ApiResponse(
    val users: List<UserApiEntity>
) {
    override fun toString(): String {
        return "ApiResponse(users=$users)"
    }
}
