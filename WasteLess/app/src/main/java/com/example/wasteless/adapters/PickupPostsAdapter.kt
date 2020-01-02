package com.example.wasteless.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteless.R
import kotlinx.android.synthetic.main.cell_donationpost.view.*
import kotlinx.android.synthetic.main.fragment_pickup.view.*

class PickupPostsAdapter(val context: Context) : RecyclerView.Adapter<PickupPostsAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_donationpost,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 10
    }

    class CustomViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val name = view.postcell_donorName
    }
}
