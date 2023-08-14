package com.example.avantsoft.core


class UserApiEntity(
    private val id: Int,
    private val name: String,
    private val age: Int,
    private val email: String,
) {

    fun toUser(): UserModel {
        return UserModel(id, name, age, email)
    }
}