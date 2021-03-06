package com.example.wasteless.networking

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.wasteless.model.Donation
import com.example.wasteless.model.DonationList
import com.example.wasteless.model.LoginCredential
import com.example.wasteless.model.Participant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WastelessRepository {

    var wastelessRepository: WastelessRepository? = null

    fun getInstance(): WastelessRepository {
        if(wastelessRepository == null){
            return WastelessRepository() as WastelessRepository
        }
        return wastelessRepository as WastelessRepository
    }

    var wastelessAPI: WastelessAPI? = null

    init{
        wastelessAPI =  RetrofitService().createService(WastelessAPI::class.java)
    }

    fun createParticipant(participant: Participant): MutableLiveData<Participant> {
        val call: Call<Participant> = wastelessAPI!!.createParticipant(participant)
        val participantData: MutableLiveData<Participant> = MutableLiveData()
        call.enqueue(object: Callback<Participant> {
            override fun onFailure(call: Call<Participant>?, t: Throwable?) {
                Log.d("FAIL : USER CREATION",t!!.message)
            }

            override fun onResponse(call: Call<Participant>?, response: Response<Participant>?) {
                Log.d("SUCCESS : USER CREATION","SUCCESS")
                response?.let {
                    participantData.value = it.body()
                }

            }
        })
        return participantData
    }


    fun updateParticipant(participant: Participant): MutableLiveData<Participant> {
        val call: Call<Participant> = wastelessAPI!!.updateParticipant(participant,participant.id!!)
        val participantData: MutableLiveData<Participant> = MutableLiveData()
        call.enqueue(object: Callback<Participant> {
            override fun onFailure(call: Call<Participant>?, t: Throwable?) {
                Log.d("FAIL : USER CREATION",t!!.message)
            }

            override fun onResponse(call: Call<Participant>?, response: Response<Participant>?) {
                Log.d("SUCCESS : USER CREATION","SUCCESS")
                response?.let {
                    participantData.value = it.body()
                }

            }
        })
        return participantData
    }



    fun createDonation(donation: Donation): MutableLiveData<Donation> {
        val call: Call<Donation> = wastelessAPI!!.createDonation(donation)
        val donationData: MutableLiveData<Donation> = MutableLiveData()
        call.enqueue(object: Callback<Donation> {
            override fun onFailure(call: Call<Donation>?, t: Throwable?) {
                Log.d("DONATION FAIL",t!!.message)
            }

            override fun onResponse(call: Call<Donation>?, response: Response<Donation>?) {
                response?.let {
                    donationData.value = it.body()
                    Log.d("DONATION CREATION","SUCCESS")
                }

            }
        })
        return donationData
    }

    fun getDonations(): MutableLiveData<DonationList> {
        val call: Call<DonationList> = wastelessAPI!!.getDonations()
        val donationData: MutableLiveData<DonationList> = MutableLiveData()
        call.enqueue(object: Callback<DonationList> {
            override fun onFailure(call: Call<DonationList>?, t: Throwable?) {
                Log.d("DONATION FAIL",t!!.message)
            }

            override fun onResponse(call: Call<DonationList>?, response: Response<DonationList>?) {
                response?.let {
                    donationData.value = it.body()
                    Log.d("DONATION CREATION","SUCCESS")
                }
            }
        })
        return donationData
    }


    fun validateLoginCredentials(credentials: LoginCredential) : MutableLiveData<Participant> {
        val call: Call<Participant> = wastelessAPI!!.validateLoginCredentials(credentials)
        val participantData: MutableLiveData<Participant> = MutableLiveData()
        call.enqueue(object: Callback<Participant> {
            override fun onFailure(call: Call<Participant>?, t: Throwable?) {
                Log.d("LOGIN FAIL",t!!.message)
            }

            override fun onResponse(call: Call<Participant>?, response: Response<Participant>?) {
                response?.let {
                    participantData.value = it.body()
                    Log.d("LOGIN","SUCCESS")
                    if(it.body() == null){
                        Log.d("Data","NULL")
                    }
                    Log.d("CODE - ",response.code().toString())
                }
            }
        })
        return participantData
    }



}