package com.example.wasteless.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.wasteless.R
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity: CustomAppActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setButtonActions()
        hideErrorMessages()
    }

    private fun setButtonActions() {
        backButton.setOnClickListener {
            this.finish()
        }
        signUpButton.setOnClickListener {
            if(validateField()){
                val intent = Intent(applicationContext, DonorHomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun hideErrorMessages(){
        nameTVError.visibility = View.GONE
        emailTVError.visibility = View.GONE
        passwordTVError.visibility = View.GONE
        retypePasswordTVError.visibility = View.GONE
        addressOneTVError.visibility = View.GONE
        addressTwoTVError.visibility = View.GONE
        cityTVError.visibility = View.GONE
        stateTVError.visibility = View.GONE
    }

    private fun validateField():Boolean {
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