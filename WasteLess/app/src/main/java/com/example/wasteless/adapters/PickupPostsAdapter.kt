package com.example.wasteless.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteless.R
import kotlinx.android.synthetic.main.cell_donationpost.view.*

import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PickupPostsAdapter(val context: Context) : RecyclerView.Adapter<PickupPostsAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_donationpost,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.pickupBtn.setOnClickListener {
                            MaterialAlertDialogBuilder(context)
                    .setTitle("Confirm")
                   .setMessage("Are you sure that you can pick "+position+" up under 30 minutes?")
                    .setPositiveButton("Yes", null)
                    .setNegativeButton("No",null)
                    .show()
        }
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 10
    }

    class CustomViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val name = view.postcell_donorName
        val pickupBtn = view.postcell_pickupBtn
    }
}
