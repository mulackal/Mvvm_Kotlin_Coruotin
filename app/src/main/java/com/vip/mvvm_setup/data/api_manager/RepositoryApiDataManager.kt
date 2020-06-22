package com.vip.mvvm_setup.data.api_manager


import com.vip.mvvm_setup.data.api_manager.retrofit.ApiCleint
import com.vip.mvvm_setup.data.api_manager.retrofit.ApiParams
import com.vip.mvvm_setup.data.api_manager.retrofit.CommonApiRequest
import com.vip.mvvm_setup.ui.activity.home.HomeCategoryRespond
import com.vip.mvvm_setup.ui.activity.login.LoginResponds


object RepositoryApiDataManager : CommonApiRequest() {


    suspend fun userLogin(dataclass: ApiParams): LoginResponds {
        return apiRequest { ApiCleint.apiService.login(dataclass) }
    }

    suspend fun homeData(dataclass: ApiParams): HomeCategoryRespond {
        return apiRequest { ApiCleint.apiService.subCategoryProducts(dataclass) }
    }


}