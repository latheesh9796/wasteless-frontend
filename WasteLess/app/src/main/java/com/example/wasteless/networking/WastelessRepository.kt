package com.example.wasteless.networking

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

}