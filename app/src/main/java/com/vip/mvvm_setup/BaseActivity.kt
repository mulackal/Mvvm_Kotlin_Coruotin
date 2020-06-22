package com.vip.mvvm_setup

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle

import android.text.Html
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.snackbar.Snackbar
import com.vip.mvvm_setup.BuildConfig
import com.vip.mvvm_setup.R


open class BaseActivity : AppCompatActivity() {

   /* internal lateinit var intentFilter_network: IntentFilter
    internal var receiver_network: NetworkReceiver? = null

    internal var dataTrackingReciever: DataTrackingReciever? = null
    internal lateinit var intentFilter_datatracking: IntentFilter*/

    // This is for showing the progress
    var mLoadingDialog: Dialog? = null


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

     /*   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            if (receiver_network == null) {
                intentFilter_network = IntentFilter()
                intentFilter_network.addAction(CONNECTIVITY_ACTION)
                intentFilter_network.addAction("android.net.wifi.WIFI_STATE_CHANGED")
                intentFilter_network.addAction("android.net.wifi.STATE_CHANGE")
                intentFilter_network.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE")
                receiver_network = NetworkReceiver()

                registerReceiver(receiver_network, intentFilter_network)

            }
            if (dataTrackingReciever == null) {
                intentFilter_datatracking = IntentFilter()
                intentFilter_datatracking.addAction("com.rhombus.medicintrack.OFFLINEJOB")
                dataTrackingReciever = DataTrackingReciever()

                registerReceiver(dataTrackingReciever, intentFilter_datatracking)

            }
        }*/


    }


    override fun onDestroy() {
        super.onDestroy()
      /*  try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                unregisterReceiver(receiver_network)
                unregisterReceiver(dataTrackingReciever)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }*/


    }


    fun showSnackBar(snackBarView: View, message: String) {
        val snackbar: Snackbar
        snackbar = Snackbar.make(snackBarView, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }


    fun debugLogD(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }

    fun debugLogE(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

    fun showLoadingDialog(context: Context) {
        if (mLoadingDialog == null) {
            callLoader(context)
        }else{
            hideaLoadingDialog()
            callLoader(context)
        }
    }

    private fun callLoader(context: Context) {
        mLoadingDialog = Dialog(context)
        mLoadingDialog!!.setCancelable(false)
        mLoadingDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mLoadingDialog!!.setContentView(R.layout.dialogue_loading_layout)
        mLoadingDialog!!.window!!.setBackgroundDrawableResource(
            android.R.color.transparent)

        mLoadingDialog!!.show()
    }

    // This is for hiding the progress
    fun hideaLoadingDialog() {
        if (mLoadingDialog != null)
            if (mLoadingDialog!!.isShowing) {
                mLoadingDialog!!.cancel()
                mLoadingDialog!!.window!!.closeAllPanels()
            }
    }


    override fun onResume() {
        super.onResume()
        //	BaseApplication.instance.setCurrentActivity(this)
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun showActivityCloseDialoge(context: Context,msg:String) {

        val alertDialogBuilder = AlertDialog.Builder(ContextThemeWrapper(context,
                R.style.AppTheme))

        // set title
        alertDialogBuilder.setTitle(Html.fromHtml("<font color='#ffa000'>Warning</font>"))

        // set dialog message
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel() })


        // create alert dialog
        val alertDialog = alertDialogBuilder.create()

        // show it
        alertDialog.show()
    }

}
