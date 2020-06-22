/*
package com.vip.mvvm_setup.ui.dialoge

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rhombus.budgetpharma.Utils.SharedPreferenceUtils
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.data.SharedValues

class LogoutDialogue(private val home: Activity) : Dialog(home) {
    var logoutDataBinding: LogoutDataBinding? = null

    private val preferenceUtils: SharedPreferenceUtils = SharedPreferenceUtils(home)

    init {
        //  mView = (PreviousOrderContract.View) home;
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        logoutDataBinding = DataBindingUtil.setContentView(home, R.layout.logout_popup)
        this.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        OnInit()
    }

    private fun OnInit() {
        logoutDataBinding!!.sendbtn!!.setOnClickListener {
            Toast.makeText(home, "Logged out", Toast.LENGTH_SHORT).show()
            dismiss()
            preferenceUtils.setValue(SharedValues.IS_LOGGED_IN, false)
        }
    }

}*/
