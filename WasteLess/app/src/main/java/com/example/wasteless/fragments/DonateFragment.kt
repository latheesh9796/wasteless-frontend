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
            donate_descriptionET.error = getString(R.string.field_empty)
        }
        if(donate_addressOneET.text!!.isEmpty()){
            flag = false
            donate_addressOneET.error = getString(R.string.field_empty)
        }
        if(donate_cityET.text!!.isEmpty()){
            flag = false
            donate_cityET.error = getString(R.string.field_empty)
        }
        if(donate_stateET.text!!.isEmpty()){
            flag = false
            donate_stateET.error = getString(R.string.field_empty)
        }

        if(donate_zipET.text!!.isEmpty()){
            flag = false
            donate_zipET.error = getString(R.string.field_empty)
        }

        if(donate_zipET.text!!.isEmpty()){
            flag = false
            donate_phoneET.error = getString(R.string.field_empty)
        }
        return flag
    }

    private fun hideErrorMessages(){
        donate_descriptionET.error = null
        donate_addressOneET.error = null
        donate_addressTwoET.error = null
        donate_cityET.error = null
        donate_stateET.error = null
        donate_zipET.error = null
        donate_phoneET.error = null
    }

    companion object {
        fun newInstance(): DonateFragment = DonateFragment()
    }
}
