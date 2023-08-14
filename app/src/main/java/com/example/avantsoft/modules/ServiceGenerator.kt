package com.example.avantsoft.modules

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

}