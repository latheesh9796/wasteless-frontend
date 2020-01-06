package com.example.wasteless.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wasteless.R
import com.example.wasteless.model.Participant
import com.example.wasteless.utils.Utilities
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import com.example.wasteless.viewmodels.ParticipantViewModel
import retrofit2.Callback
import retrofit2.Response


class SignupActivity: CustomAppActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.wasteless.R.layout.activity_signup)
        setButtonActions()
        hideErrorMessages()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build() //For accessing localhost or any http request
        StrictMode.setThreadPolicy(policy)                                 //Remove before production
    }

    private fun setButtonActions() {
        backButton.setOnClickListener {
            this.finish()
        }
        signUpButton.setOnClickListener {
            if(validateFields()){
                val name = nameET.text.toString()
                val email = emailET.text.toString()
                val password = emailET.text.toString()
                val address1 = addressOneET.text.toString()
                val address2 = addressTwoET.text.toString()
                val city = cityET.text.toString()
                val state = stateET.text.toString()
                val zipcode = zipET.text.toString()
                val phone = phoneET.text.toString()
                val participant = Participant(address1,address2,city,"usa",email,null,name,password,phone,state,zipcode)
                if(Utilities().isInternetAvailable()){
                    var participantViewModel = ViewModelProviders.of(this).get(ParticipantViewModel::class.java)
                    participantViewModel.init()
                    participantViewModel.createParticipant(participant)
                    participantViewModel.getParticipantRepository().observe(this, Observer {
                        it?.let {
                            if(it.id != null) {
                                Log.d("Successfully added","bla bla bla")
                                updateSharedPreferences(it)
                                val intent = Intent(applicationContext, HomeActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this,"Sign up error",Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }
            }
        }
    }

    private fun updateSharedPreferences(participant:Participant) {
        val sharedPreference =  getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("name",participant.name)
        editor.putString("email",participant.email)
        editor.putString("password",participant.password)
        editor.putString("address1",participant.address1)
        editor.putString("address2",participant.address2)
        editor.putString("state",participant.state)
        editor.putString("city",participant.city)
        editor.putString("zipcode",participant.zipcode)
        editor.putString("country",participant.country)
        editor.putString("phone",participant.phone)
        editor.commit()
    }

    private fun hideErrorMessages(){
        nameTVError.visibility = View.GONE
        emailTVError.visibility = View.GONE
        passwordTVError.visibility = View.GONE
        retypePasswordTVError.visibility = View.GONE
        addressOneTVError.visibility = View.GONE
        addressTwoTVError.visibility = View.GONE
        cityTVError.visibility = View.GONE
        zipTVError.visibility = View.GONE
        stateTVError.visibility = View.GONE
        phoneTVError.visibility = View.GONE
    }

    private fun validateFields():Boolean {
        hideErrorMessages()
        var flag = true
        if(nameET.text!!.isEmpty()){
            flag = false
            nameTVError.visibility = View.VISIBLE
        }
        if(emailET.text!!.isEmpty()){
            flag = false
            emailTVError.visibility = View.VISIBLE
        }
        if(passwordET.text!!.isEmpty()){
            flag = false
            passwordTVError.visibility = View.VISIBLE
        }
        if(retypePasswordET.text!!.isEmpty()){
            flag = false
            retypePasswordTVError.text = "Field Cannot be empty"
            retypePasswordTVError.visibility = View.VISIBLE
        }
        if(addressOneET.text!!.isEmpty()){
            flag = false
            addressOneTVError.visibility = View.VISIBLE
        }
        if(addressTwoET.text!!.isEmpty()){
            flag = false
            addressTwoTVError.visibility = View.VISIBLE
        }
        if(stateET.text!!.isEmpty()){
            flag = false
            stateTVError.visibility = View.VISIBLE
        }
        if(cityET.text!!.isEmpty()){
            flag = false
            cityTVError.visibility = View.VISIBLE
        }

        if(phoneET.text!!.isEmpty()){
            flag = false
            phoneTVError.visibility = View.VISIBLE
        }

        if(zipET.text!!.isEmpty()){
            flag = false
            zipTVError.visibility = View.VISIBLE
        }
        if((!passwordET.text!!.isEmpty() && !retypePasswordET.text!!.isEmpty()) ){
            if((passwordET.text.toString() != retypePasswordET.text.toString())){
                Toast.makeText(this,"pass"+passwordET.text,Toast.LENGTH_SHORT)
                Toast.makeText(this,"retype"+retypePasswordET.text,Toast.LENGTH_SHORT)
                flag = false
                retypePasswordTVError.text = "Password does not match"
                retypePasswordTVError.visibility = View.VISIBLE
            }
        }
        return flag
    }
}