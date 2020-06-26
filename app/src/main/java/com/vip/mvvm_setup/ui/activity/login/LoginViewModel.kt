package com.vip.mvvm_setup.ui.activity.login

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.vip.mvvm_setup.BaseViewModel
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.data.SharedValues
import com.vip.mvvm_setup.data.api_manager.RepositoryApiDataManager
import com.vip.mvvm_setup.data.api_manager.retrofit.*
import com.vip.mvvm_setup.utils.NetworkServiceManager
import com.vip.mvvm_setup.utils.coroutin.Coroutines
import kotlinx.coroutines.*
import java.lang.Exception


class LoginViewModel(activity: Application) : BaseViewModel<Any?>(activity) {

    var usernmae = ObservableField("")
    var password = ObservableField("")
    var apiRespondsData = MutableLiveData<LoginData>()
    var context: Context = activity



    fun geLoginResult(): LiveData<LoginData> {
        return apiRespondsData
    }

    fun login() {
        if (usernmae.get()!!.trim { it <= ' ' }.isNotEmpty() && password.get()!!.trim { it <= ' ' }.isNotEmpty()) {
            if (NetworkServiceManager.getInstance(context).isNetworkAvailable) {

                    setIsLoading(true)

                    val header = Header()
                    header.firmcode = preferenceUtils!!.getStringValue(SharedValues.FIRMCODE, "05")
                    header.mobile = usernmae.get()
                    header.password = password.get()

                    val datum = DataApi()
                    datum.header = header

                    val dataclass = ApiParams()
                    dataclass.data = listOf(datum)


                    val gson = Gson()
                    var json = gson.toJson(dataclass)
                    Log.e("LoginCall", "- $json")

                   job = Job()
                   job?.let { theJob ->
                       CoroutineScope(Dispatchers.IO + theJob).launch {

                           try {
                               val loginData = RepositoryApiDataManager.userLogin(dataclass)

                               if (loginData?.data != null){
                               /** for ui to set value**/
                                   Coroutines.main {
                                       Log.e("LoginCall", "- success")
                                       setIsLoading(false)
                                       apiRespondsData.value = loginData.data!!
                                       theJob.complete()
                                   }

                             }else{
                                   Log.e("LoginCall", "- null")
                                   Coroutines.main {
                                       setIsLoading(false)
                                       if (loginData!=null)
                                           ShowErrorMessage(loginData.message!!)
                                       else
                                          ShowErrorMessage(context.resources.getString(R.string.apierror))
                                   }
                               }
                           }catch (e:Exception){
                               Log.e("LoginCall", "error")
                               Coroutines.main {
                                   setIsLoading(false)
                                   ShowErrorMessage(context.resources.getString(R.string.apierror))
                               }
                               e.printStackTrace()
                           }
                   }
                }

            }else{
                ShowWarningMessage(context.resources.getString(R.string.no_network))
            }
        } else {
            ShowWarningMessage("Enter valid information")
        }
    }



    fun ShowErrorMessage(message: String) {
        setIsLoading(false)
        ShowToast(message)
    }

    private fun ShowWarningMessage(message: String) {
        ShowToast(message)
    }


}