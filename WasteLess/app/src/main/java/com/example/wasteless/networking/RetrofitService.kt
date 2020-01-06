package com.example.wasteless.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://18.191.178.243:8090/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    public fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}