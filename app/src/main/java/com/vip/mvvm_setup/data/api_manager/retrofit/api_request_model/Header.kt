package com.vip.mvvm_setup.data.api_manager.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Header {

    @SerializedName("firmcode")
    @Expose
    var firmcode: String? = null

    @SerializedName("phoneNumber")
    @Expose
    var phoneNumber: String? = null
    @SerializedName("userName")
    @Expose
    var userName: String? = null
    @SerializedName("emailId")
    @Expose
    var emailId: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("userid")
    @Expose
    var userid: String? = null
    @SerializedName("usercode")
    @Expose
    var usercode: String? = null
    @SerializedName("ordersrno")
    @Expose
    var ordersrno: String? = null


    @SerializedName("mobile")
    @Expose
    var mobile: String? = null
    @SerializedName("dmanName")
    @Expose
    var name: String? = null


    @SerializedName("catcode")
    @Expose
    var catcode: String? = null
    @SerializedName("subcatcode")
    @Expose
    var subcatcode: String? = null

}
