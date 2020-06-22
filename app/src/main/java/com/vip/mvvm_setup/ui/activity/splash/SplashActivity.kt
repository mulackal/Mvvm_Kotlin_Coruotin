package com.vip.mvvm_setup.ui.activity.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vip.mvvm_setup.BaseActivity
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.databinding.SplashDataBinding

class SplashActivity : BaseActivity() {
    var activityMainBinding: SplashDataBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        activityMainBinding!!.splashviewdemModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        activityMainBinding!!.splashviewdemModel!!.setRemoveHandler()
        activityMainBinding!!.unbind()
        finish()
        super.onDestroy()
    }
}