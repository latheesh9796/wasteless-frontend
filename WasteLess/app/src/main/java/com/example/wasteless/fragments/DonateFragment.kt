package com.example.wasteless.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wasteless.R
import kotlinx.android.synthetic.main.fragment_donate.*
import android.widget.Toast


class DonateFragment  : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val activity = getActivity().let{it ->
            val layoutInflater = it!!.getLayoutInflater()
            val view = layoutInflater.inflate(R.layout.fragment_donate, container, false)
            return view
        }
        return inflater.inflate(R.layout.activity_errorpage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideErrorMessages()
        setButtonActions()
        setUserDetails()
    }

    private fun setUserDetails() {

        val sharedPreference =  this.activity!!.getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE)
        val address1 = sharedPreference.getString("address1","--")
        val address2 = sharedPreference.getString("address2","--")
        val city = sharedPreference.getString("city","--")
        val state = sharedPreference.getString("state","--")
        val zipcode = sharedPreference.getString("zipcode","0")
        val phone = sharedPreference.getString("phone","0")
        donate_addressOneET.setText(address1)
        donate_addressTwoET.setText(address2)
        donate_cityET.setText(city)
        donate_stateET.setText(state)
        donate_zipET.setText(zipcode)
        donate_phoneET.setText(phone)
    }

    private fun setButtonActions(){
        donate_donateButton.setOnClickListener {
            hideErrorMessages()
            if(validateFields()){
                Toast.makeText(context,"Donation Successful",Toast.LENGTH_SHORT)
            }
        }
    }
    private fun validateFields():Boolean {
        hideErrorMessages()
        var flag = true
        if(donate_descriptionET.text!!.isEmpty()){
            flag = false
            donate_descriptionTVError.visibility = View.VISIBLE
        }
        if(donate_addressOneET.text!!.isEmpty()){
            flag = false
            donate_addressOneTVError.visibility = View.VISIBLE
        }
        if(donate_addressTwoET.text!!.isEmpty()){
            flag = false
            donate_addressTwoTVError.visibility = View.VISIBLE
        }
        if(donate_stateET.text!!.isEmpty()){
            flag = false
            donate_stateTVError.visibility = View.VISIBLE
        }
        if(donate_cityET.text!!.isEmpty()){
            flag = false
            donate_cityTVError.visibility = View.VISIBLE
        }

        if(donate_zipET.text!!.isEmpty()){
            flag = false
            donate_zipTVError.visibility = View.VISIBLE
        }

        if(donate_zipET.text!!.isEmpty()){
            flag = false
            donate_zipTVError.visibility = View.VISIBLE
        }
        return flag
    }

    private fun hideErrorMessages(){
        donate_descriptionTVError.visibility = View.GONE
        donate_addressOneTVError.visibility = View.GONE
        donate_addressTwoTVError.visibility = View.GONE
        donate_cityTVError.visibility = View.GONE
        donate_stateTVError.visibility = View.GONE
        donate_zipTVError.visibility = View.GONE
        donate_phoneTVError.visibility = View.GONE
    }

    companion object {
        fun newInstance(): DonateFragment = DonateFragment()
    }
}
