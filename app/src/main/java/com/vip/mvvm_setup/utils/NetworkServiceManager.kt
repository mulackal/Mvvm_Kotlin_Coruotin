package com.vip.mvvm_setup.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkServiceManager(internal var context: Context) {


    val isNetworkAvailable: Boolean
        @SuppressLint("MissingPermission")
        get() {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo: NetworkInfo? = null
            assert(cm != null)
            if (cm.activeNetworkInfo != null) {
                networkInfo = cm.activeNetworkInfo
                return networkInfo != null && networkInfo.isConnected
            } else {
                return false
            }

        }

    companion object {

        private var networkServiceManager: NetworkServiceManager? = null

        fun getInstance(context: Context): NetworkServiceManager {
            if (networkServiceManager == null) {
                networkServiceManager = NetworkServiceManager(context)
            }
            return networkServiceManager as NetworkServiceManager
        }
    }

}