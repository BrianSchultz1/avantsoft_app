package com.example.avantsoft.modules

import com.example.avantsoft.core.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("ce47ee53-6531-4821-a6f6-71a188eaaee0")
    abstract fun getUsers(): Call<ApiResponse>

}