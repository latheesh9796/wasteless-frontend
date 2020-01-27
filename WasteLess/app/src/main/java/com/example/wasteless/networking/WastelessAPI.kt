package com.example.wasteless.networking

import com.example.wasteless.model.Donation
import com.example.wasteless.model.DonationList
import com.example.wasteless.model.LoginCredential
import com.example.wasteless.model.Participant
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.PUT



interface WastelessAPI  {

    @POST("donors")
    fun createParticipant(@Body participant: Participant): Call<Participant>

    @POST("donations")
    fun createDonation(@Body donation: Donation): Call<Donation>

    @GET("donations")
    fun getDonations():Call<DonationList>

    @PUT("donors/{donorId}")
    fun updateParticipant(@Body participant: Participant, @Path( "donorId") id: Int): Call<Participant>

    @POST("/donors/login")
    fun validateLoginCredentials(@Body credentials: LoginCredential) : Call<Participant>

}