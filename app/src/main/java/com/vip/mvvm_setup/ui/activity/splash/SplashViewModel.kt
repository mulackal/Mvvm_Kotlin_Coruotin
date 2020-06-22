package com.vip.mvvm_setup.ui.activity.splash

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Handler
import com.vip.mvvm_setup.BaseViewModel
import com.vip.mvvm_setup.data.SharedValues
import com.vip.mvvm_setup.data.SharedValues.ADDRESS
import com.vip.mvvm_setup.data.SharedValues.IS_LOGGED
import com.vip.mvvm_setup.ui.activity.home.HomePage
import com.vip.mvvm_setup.ui.activity.login.LoginActivity

class SplashViewModel(activity: Application) : BaseViewModel<Any?>(activity) {
    var context: Context = activity

    private val SPLASH_TIME_OUT = 3000
    private var handler: Handler? = null
    private var runnable: Runnable? = null

    fun splashTimeOut() {
        handler = Handler()
        runnable = Runnable { gotoNextScreen() }
        handler!!.postDelayed(runnable, SPLASH_TIME_OUT.toLong())
    }

    fun gotoNextScreen() {
        if (preferenceUtils.getBoolanValue(IS_LOGGED, false)) {
            gotoHomeScreen()
        } else {
            gotoLoginScreen()
        }
    }

    fun gotoLoginScreen() {
        val login = Intent(context, LoginActivity::class.java)
        login.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(login)
    }

    fun gotoHomeScreen() {
        val login = Intent(context, HomePage::class.java)
        login.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(login)
    }

    fun setRemoveHandler() {
        try {
            handler!!.removeCallbacks(runnable)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    init {
        preferenceUtils.setValue(SharedValues.ADDRESS, "my address")
        splashTimeOut()
    }
}