package com.example.wasteless.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class CustomAppActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.let {actionBar ->
            actionBar.hide()
        }
    }

}