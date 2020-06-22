package com.vip.mvvm_setup.ui.activity.home

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeProductwiseData {

    @SerializedName("c_code")
    @Expose
    var cCode: String? = null
    @SerializedName("c_name")
    @Expose
    var cName: String? = null
    @SerializedName("mfacname")
    @Expose
    var mfacname: String? = null
    @SerializedName("Pack")
    @Expose
    var Pack: String? = null
    @SerializedName("c_short_name")
    @Expose
    var cShortName: String? = null
    @SerializedName("c_image_url")
    @Expose
    var cImageUrl: String? = null
    @SerializedName("n_max_mrp")
    @Expose
    var nMaxMrp: String? = null
    @SerializedName("n_min_sale_qty")
    @Expose
    var nMinSaleQty: String? = null

    @SerializedName("disc")
    @Expose
    var disc: Double? = null
    @SerializedName("type")
    @Expose
    var type: String? = null



}
