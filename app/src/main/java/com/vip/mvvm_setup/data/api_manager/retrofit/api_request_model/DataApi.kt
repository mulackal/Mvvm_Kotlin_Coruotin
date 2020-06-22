package com.vip.mvvm_setup.data.api_manager.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataApi {

    @SerializedName("header")
    @Expose
    var header: Header? = null

    /*@SerializedName("itemdata")
    @Expose
    var itemdata: List<Itemdata>? = null*/

}

