package com.vip.mvvm_setup.data.api_manager.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiParams {

    @SerializedName("data")
    @Expose
    var data: List<DataApi>? = null

}
