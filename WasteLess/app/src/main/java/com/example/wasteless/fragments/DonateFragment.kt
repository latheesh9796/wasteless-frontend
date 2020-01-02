package com.example.wasteless.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wasteless.R
import kotlinx.android.synthetic.main.fragment_donate.*
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder


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
    }

    private fun setButtonActions(){
        donate_donateButton.setOnClickListener {
            hideErrorMessages()
            if(validateFields()){
                Toast.makeText(context,"Donation Successful",Toast.LENGTH_SHORT)
//                MaterialAlertDialogBuilder(context)
//                    .setTitle("Confirm")
//                    .setMessage("Are you sure that you can pick this up under 30 minutes?")
//                    .setPositiveButton("Yes", null)
//                    .setNegativeButton("No",null)
//                    .show()
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
        return flag
    }

    private fun hideErrorMessages(){
        donate_descriptionTVError.visibility = View.GONE
        donate_addressOneTVError.visibility = View.GONE
        donate_addressTwoTVError.visibility = View.GONE
        donate_cityTVError.visibility = View.GONE
        donate_stateTVError.visibility = View.GONE
    }

    companion object {
        fun newInstance(): DonateFragment = DonateFragment()
    }
}
