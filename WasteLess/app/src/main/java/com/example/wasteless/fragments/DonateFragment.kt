package com.example.wasteless.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wasteless.R

class DonateFragment  : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_donate, container, false)

    companion object {
        fun newInstance(): DonateFragment = DonateFragment()
    }
}
