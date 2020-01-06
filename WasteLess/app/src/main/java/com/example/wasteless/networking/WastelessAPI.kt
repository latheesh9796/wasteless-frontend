package com.example.wasteless.networking

import com.example.wasteless.model.Participant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WastelessAPI  {

    @POST("donors")
    fun createParticipant(@Body participant: Participant): Call<Participant>
}