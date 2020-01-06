package com.example.wasteless.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wasteless.R
import com.example.wasteless.activities.LoginActivity
import com.example.wasteless.activities.SignupActivity
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_aboutme.*

class AboutMeFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val activity = getActivity().let{it ->
            val layoutInflater = it!!.getLayoutInflater()
            val view = layoutInflater.inflate(R.layout.fragment_aboutme, container, false)
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
        val name = sharedPreference.getString("name","--")
        val address1 = sharedPreference.getString("address1","--")
        val address2 = sharedPreference.getString("address2","--")
        val city = sharedPreference.getString("city","--")
        val state = sharedPreference.getString("state","--")
        val zipcode = sharedPreference.getString("zipcode","0")
        val phone = sharedPreference.getString("phone","0")
        aboutme_nameET.setText(name)
        aboutme_addressOneET.setText(address1)
        aboutme_addressTwoET.setText(address2)
        aboutme_cityET.setText(city)
        aboutme_stateET.setText(state)
        aboutme_zipET.setText(zipcode)
        aboutme_phoneET.setText(phone)

    }

    private fun setButtonActions() {
        aboutme_updateButton.setOnClickListener {

        }
        aboutme_logoutButton.setOnClickListener {

            val sharedPreference =  this.activity!!.getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
            val intent = Intent(this.context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun hideErrorMessages() {
        aboutme_addressOneET.error = null
        aboutme_addressTwoET.error = null
        aboutme_cityET.error = null
        aboutme_stateET.error = null
        aboutme_zipET.error = null
        aboutme_phoneET.error = null

    }

    companion object {
            fun newInstance(): AboutMeFragment = AboutMeFragment()
        }
}
