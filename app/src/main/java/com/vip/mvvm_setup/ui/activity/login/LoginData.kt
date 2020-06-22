package com.vip.mvvm_setup.ui.activity.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginData {
    @SerializedName("userid")
    @Expose
    var userid: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("address")
    @Expose
    var address: String? = null

    @SerializedName("mobile")
    @Expose
    var mobile: String? = null

    @SerializedName("delivered")
    @Expose
    var delivered: Int? = null

    @SerializedName("pending")
    @Expose
    var pending: Int? = null

    @SerializedName("kmcovered")
    @Expose
    var kmcovered: Double? = null

}