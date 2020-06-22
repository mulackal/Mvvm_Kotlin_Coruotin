package com.vip.mvvm_setup.ui.activity.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponds {
    @SerializedName("status")
    @Expose
    var status: Boolean? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: LoginData? = null

}