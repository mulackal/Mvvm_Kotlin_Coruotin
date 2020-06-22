package com.vip.mvvm_setup.data.api_manager.retrofit


import com.vip.mvvm_setup.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor




import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiCleint {

        private val stethoClient: OkHttpClient
            get() = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()


    val retrofitBuilder: Retrofit.Builder by lazy {
             Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL_STAGING)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okClient())
            .client(stethoClient)
    }


        private fun okClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .build()
        }


    val apiService: ApiInterface by lazy {
              retrofitBuilder.build()
             .create(ApiInterface::class.java)
    }


}
