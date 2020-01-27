package com.example.wasteless.fragments

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteless.R
import com.example.wasteless.adapters.PickupPostsAdapter
import com.example.wasteless.utils.Utilities
import com.example.wasteless.viewmodels.DonationViewModel
import kotlinx.android.synthetic.main.fragment_pickup.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PickupFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_pickup, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadDonations()
    }
    companion object {
        fun newInstance(): PickupFragment = PickupFragment()
    }
    private fun loadDonations(){
        if(Utilities().isInternetAvailable()){
            var donationViewModel = ViewModelProviders.of(this).get(DonationViewModel::class.java)
            donationViewModel.init()
            donationViewModel.getDonations()
            donationViewModel.getDonationsResponse().observe(this, Observer {
                it?.let {
                    if(it != null) {
                        Log.e("Size of list" , it!!.donations!!.size.toString())
                        pickup_posts_recyclerview.layoutManager = LinearLayoutManager(this.context)
                        pickup_posts_recyclerview.adapter = PickupPostsAdapter(this.context!!,it!!.donations!!)
                    } else {
                        Log.e("error","Couldn't recieve donations data")
                    }
                }
            })
        }
    }
}