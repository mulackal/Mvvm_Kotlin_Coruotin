package com.vip.mvvm_setup.ui.activity.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeCategoryRespond {
    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: List<HomeProductwiseData>? = null

}
