package com.vip.mvvm_setup.data.api_manager.retrofit



import com.vip.mvvm_setup.ui.activity.home.HomeCategoryRespond
import com.vip.mvvm_setup.ui.activity.login.LoginResponds
import com.vip.mvvm_setup.data.api_manager.retrofit.ApiParams
import com.vip.mvvm_setup.data.local_model.User

import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {


     @POST("dmanlogin")
     suspend fun login(@Body content: ApiParams): Response<LoginResponds>

    @FormUrlEncoded
    @POST("dmanlogin")
    suspend fun loginCall(@Field("username") user: String,
                  @Field("password") pass: String): Response<LoginResponds>

    @POST("categorywiseproducts")
    suspend fun subCategoryProducts(@Body data: ApiParams): Response<HomeCategoryRespond>

    @GET("placeholder/user/{userId}")
    suspend fun getUser(@Path("userId") userId: String): User

}
