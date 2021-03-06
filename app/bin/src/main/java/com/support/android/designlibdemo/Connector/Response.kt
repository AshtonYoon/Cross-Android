package com.support.android.designlibdemo.Connector

import android.content.*
import com.support.android.designlibdemo.Helper.*
import retrofit2.*
import retrofit2.Response

abstract class Response <T> (private val context: Context): Callback<T> {

    override fun onFailure(call: Call<T>?, t: Throwable?) = Helper.showToast(context, "네트워크 오류")

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        response?.run { setResponseData(code(), body()) }
    }

    abstract fun setResponseData(code: Int, data: T?)

}