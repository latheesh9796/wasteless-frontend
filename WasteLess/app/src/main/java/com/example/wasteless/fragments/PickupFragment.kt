package com.example.wasteless.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteless.R
import com.example.wasteless.adapters.PickupPostsAdapter
import kotlinx.android.synthetic.main.fragment_pickup.*

class PickupFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_pickup, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pickup_posts_recyclerview.layoutManager = LinearLayoutManager(this.context)
        pickup_posts_recyclerview.adapter = PickupPostsAdapter(this.context!!)
    }
    companion object {
        fun newInstance(): PickupFragment = PickupFragment()
    }
}