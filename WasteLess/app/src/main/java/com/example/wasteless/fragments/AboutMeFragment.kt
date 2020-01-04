package com.example.wasteless.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wasteless.R
import com.example.wasteless.activities.LoginActivity
import com.example.wasteless.activities.SignupActivity
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
    }

    private fun setButtonActions() {
        aboutme_updateButton.setOnClickListener {

        }
        aboutme_logoutButton.setOnClickListener {
            val intent = Intent(this.context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun hideErrorMessages() {
        aboutme_nameTVError.visibility = View.GONE
        aboutme_addressOneTVError.visibility = View.GONE
        aboutme_addressTwoTVError.visibility = View.GONE
        aboutme_cityTVError.visibility = View.GONE
        aboutme_stateTVError.visibility = View.GONE
        aboutme_phoneTVError.visibility = View.GONE
    }

    companion object {
            fun newInstance(): AboutMeFragment = AboutMeFragment()
        }
}
