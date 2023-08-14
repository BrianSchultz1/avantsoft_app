package com.example.avantsoft.core

class UserModel(
    val id: Int,
    val name: String,
    val age: Int,
    val email: String,
) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', age=$age, email='$email')"
    }

}