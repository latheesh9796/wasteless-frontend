package com.example.wasteless.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
  //  private val url = "http://18.191.178.243:8090/" //CLOUD
 //   private val url = "http://192.168.1.33:8081/" //LOCAL
    private val url = "http://192.168.1.15:8081"
    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    public fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}