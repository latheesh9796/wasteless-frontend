package com.example.wasteless.utils

import android.app.ActionBar
import android.app.Activity
import android.location.Address
import com.google.android.gms.maps.model.LatLng
import java.net.InetAddress
import java.net.UnknownHostException
import android.location.Geocoder
import java.io.IOException


class Utilities {

    fun isInternetAvailable(): Boolean {
        try {
            val address = InetAddress.getByName("www.google.com")
            return !address.equals("")
        } catch (e: UnknownHostException) {
            // Log error
        }
        return false
    }

    fun getLocationFromAddress(addressString: String,context: Activity): LatLng? {

        val coder = Geocoder(context)
        val address: List<Address>?
        var result: LatLng? = null
        try {
            // May throw an IOException
            address = coder.getFromLocationName(addressString, 5)
            if (address == null) {
                return null
            }
            val location = address[0]
            result = LatLng(location.latitude, location.longitude)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return result

    }
}