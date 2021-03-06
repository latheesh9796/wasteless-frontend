package com.example.wasteless.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wasteless.model.LoginCredential
import com.example.wasteless.model.Participant
import com.example.wasteless.networking.WastelessRepository

class ParticipantViewModel: ViewModel() {

    var participantData : MutableLiveData<Participant>? = null
    var updatedParticipantData : MutableLiveData<Participant>? = null
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

    fun updateParticipant(participant: Participant){
        updatedParticipantData = wastelessRepository!!.updateParticipant(participant)
    }

    fun getUpdatedParticipantData():LiveData<Participant>{
        return updatedParticipantData as LiveData<Participant>
    }

    fun getParticipantData():LiveData<Participant>{
        return participantData as LiveData<Participant>
    }

    fun validateCredentials(credentials: LoginCredential){
        participantData = wastelessRepository!!.validateLoginCredentials(credentials)
    }
    }
