package com.vip.mvvm_setup.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vip.mvvm_setup.BaseActivity
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.data.SharedValues
import com.vip.mvvm_setup.data.api_manager.retrofit.ApiResource
import com.vip.mvvm_setup.databinding.LoginDataBinding
import com.vip.mvvm_setup.ui.activity.home.HomePage

class LoginActivity : BaseActivity() {

    var activityMainBinding: LoginDataBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityMainBinding!!.logviewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        ObservedLoader()

       /* activityMainBinding!!.submmit.setOnClickListener {
            startActivity(Intent(this, HomePage::class.java))
        }*/

    }



    private fun ObservedLoader() {
        activityMainBinding!!.logviewModel!!.isLoading
            .observe(this, Observer<Boolean?> { isLoading ->
                if (isLoading != null) {
                    if (isLoading)
                        showLoadingDialog(this@LoginActivity)
                    else
                        hideaLoadingDialog()
                }
            })

        activityMainBinding!!.logviewModel!!.geLoginResult()
            .observe(this, Observer<LoginData> { loginData ->

                             //activityMainBinding!!.logviewModel!!setIsLoading(false)

                                activityMainBinding!!.logviewModel!!.preferenceUtils.setValue(
                                    SharedValues.IS_LOGGED, true)

                                 Toast.makeText(this@LoginActivity, "Login Successful ${loginData.name}", Toast.LENGTH_SHORT).show()

                                 val intent = Intent(this@LoginActivity, HomePage::class.java)
                                  startActivity(intent)

                                finish()
            })
    }

    override fun onDestroy() {
        activityMainBinding!!.unbind()
        activityMainBinding!!.logviewModel!!.cancelJobs()
        super.onDestroy()
    }

}