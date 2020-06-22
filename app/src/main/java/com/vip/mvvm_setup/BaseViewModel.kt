package com.vip.mvvm_setup

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rhombus.budgetpharma.Utils.SharedPreferenceUtils
import com.vip.mvvm_setup.data.api_manager.RepositoryApiDataManager
import kotlinx.coroutines.CompletableJob

import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(internal var application: Application) : AndroidViewModel(application) {

    val preferenceUtils: SharedPreferenceUtils = SharedPreferenceUtils(application)
    val isLoading = MutableLiveData<Boolean>()
    var mNavigator: WeakReference<N>? = null //WeakReference is used to  avoid memory leaks
    var job: CompletableJob? = null

    init { }

    override fun onCleared() {
        super.onCleared()
    }

    fun cancelJobs(){
       if(job!=null)
           job?.cancel()
    }

    fun ShowToast(message: String) {
        Toast.makeText(application, "" + message, Toast.LENGTH_SHORT).show()
    }

    fun setIsLoading(isLoad: Boolean) {
        isLoading.value = isLoad
    }

    val navigator: N? get() = mNavigator!!.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

}