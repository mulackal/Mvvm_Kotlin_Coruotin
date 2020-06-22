package com.vip.mvvm_setup.data.api_manager.retrofit

class ApiResource<T> private constructor(
    val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?): ApiResource<T> {
            return ApiResource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(msg: String?, data: T?): ApiResource<T> {
            return ApiResource(
                Status.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data: T?): ApiResource<T> {
            return ApiResource(
                Status.LOADING,
                data,
                null
            )
        }
    }

}