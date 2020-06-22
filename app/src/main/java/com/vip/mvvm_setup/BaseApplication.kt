package com.vip.mvvm_setup

import android.app.Activity
import android.app.Application
import android.app.Dialog

import com.facebook.stetho.Stetho
import com.vip.mvvm_setup.utils.customviews.FontsOverride


class BaseApplication : Application() {

    private var currentActivity: Activity? = null
    private var mCurrentDialoge: Dialog? = null

    override fun onCreate() {
        super.onCreate()


        Stetho.initializeWithDefaults(this)

        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/NunitoSans-Regular.ttf")

    }

    fun getCurrentDialoge(): Dialog? {
        return mCurrentDialoge
    }

    fun setCurrentDialoge(mCurrentDialoge: Dialog) {
        this.mCurrentDialoge = mCurrentDialoge
    }

    fun getCurrentActivity(): Activity? {
        return currentActivity
    }

    fun setCurrentActivity(mCurrentact: Activity) {
        this.currentActivity = mCurrentact
    }

    companion object {
        private var uniqInstance: BaseApplication? = null

        val instance: BaseApplication
            @Synchronized get() {
                if (uniqInstance == null) {
                    uniqInstance = BaseApplication()
                }
                return uniqInstance as BaseApplication
            }
    }


}
