package com.vip.mvvm_setup.ui.activity.home

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import com.google.gson.Gson
import com.vip.mvvm_setup.BaseViewModel
import com.vip.mvvm_setup.R
import com.vip.mvvm_setup.data.SharedValues
import com.vip.mvvm_setup.data.api_manager.RepositoryApiDataManager
import com.vip.mvvm_setup.data.api_manager.retrofit.ApiParams
import com.vip.mvvm_setup.data.api_manager.retrofit.DataApi
import com.vip.mvvm_setup.data.api_manager.retrofit.Header
import com.vip.mvvm_setup.ui.callback.HomeListenerView
import com.vip.mvvm_setup.utils.NetworkServiceManager
import com.vip.mvvm_setup.utils.coroutin.Coroutines
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(var context: Application) : BaseViewModel<HomeListenerView?>(context) {

    var mDataList: ObservableList<HomeProductwiseData> = ObservableArrayList()


    init {
        loadDetails()
    }

    fun loadDetails() {
        if (NetworkServiceManager.getInstance(context).isNetworkAvailable) {

            setIsLoading(true)

            val header = Header()
            header.firmcode =  preferenceUtils!!.getStringValue(SharedValues.FIRMCODE, "04")
            header.subcatcode = "P00048"  // P00049 , P00041 , P00053  , P00033

            val datum = DataApi()
            datum.header = header

            val apiclass = ApiParams()
            apiclass.data = listOf(datum)

            val gson = Gson()
            var json = gson.toJson(apiclass)
            Log.e("CallOrder","- $json")

            
            job = Job()
            job?.let { theJob ->
                CoroutineScope(Dispatchers.IO + theJob).launch {

                    try {
                        val homeData = RepositoryApiDataManager.homeData(apiclass)

                        if (homeData?.data != null){
                            /** for ui to set value**/
                            Coroutines.main {
                                Log.e("LoginCall", "- success")
                                setIsLoading(false)
                                if (homeData.data != null && homeData.data!!.isNotEmpty()) {
                                    mDataList.clear()
                                    mDataList.addAll(homeData.data!!)
                                } else
                                    navigator!!.ShowWarningMessage("No data available")

                                theJob.complete()
                            }

                        }else{
                            Log.e("LoginCall", "- null")
                            Coroutines.main {
                                setIsLoading(false)
                                if (homeData!=null)
                                    navigator!!.ShowWarningMessage(homeData.message!!)
                                else
                                    navigator!!.ShowWarningMessage(context.resources.getString(R.string.apierror))
                            }
                        }
                    }catch (e: Exception){
                        Log.e("LoginCall", "error")
                        Coroutines.main {
                            setIsLoading(false)
                            navigator!!.ShowWarningMessage(context.resources.getString(R.string.apierror))
                        }
                        e.printStackTrace()
                    }
                }
            }

        } else {
            navigator!!.ShowWarningMessage("No network")
        }
    }


    fun deleteItem(data: String?, position: Int) {
        navigator!!.deleteItem(data, position)
    }

    fun OnLoadingData() {
        loadDetails()
    }



}