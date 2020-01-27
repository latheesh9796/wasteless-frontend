package com.example.wasteless.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wasteless.model.Donation
import com.example.wasteless.model.DonationList
import com.example.wasteless.networking.WastelessRepository

class DonationViewModel : ViewModel() {

    var donationData : MutableLiveData<Donation>? = null
    var donations : MutableLiveData<DonationList>? = null
    var wastelessRepository: WastelessRepository? = null

    fun init() {
        if(donationData != null) {
            return
        }
        wastelessRepository = WastelessRepository().getInstance()
    }

    fun createDonation(donation: Donation) {
        donationData = wastelessRepository!!.createDonation(donation)
    }

    fun getDonationCreationResponse(): LiveData<Donation> {
        return donationData as LiveData<Donation>
    }

    fun getDonationsResponse(): LiveData<DonationList>{
        return donations as LiveData<DonationList>
    }

    fun getDonations(){
        donations = wastelessRepository!!.getDonations()
    }
}