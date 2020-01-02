package com.example.wasteless.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.wasteless.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : CustomAppActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        backButton.visibility = View.INVISIBLE
        setButtonActions()
    }

    private fun setButtonActions() {
        loginButton.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
        signUpTV.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
