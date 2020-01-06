package com.example.wasteless.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wasteless.model.Participant
import com.example.wasteless.networking.WastelessRepository

class ParticipantViewModel: ViewModel() {

    var participantData : MutableLiveData<Participant>? = null
    var wastelessRepository: WastelessRepository? = null

    fun init() {
        if(participantData != null) {
            return
        }
        wastelessRepository = WastelessRepository().getInstance()
    }

    fun createParticipant(participant: Participant) {
        participantData = wastelessRepository!!.createParticipant(participant)
    }

    fun getParticipantRepository():LiveData<Participant>{
        return participantData as LiveData<Participant>
    }
    }
