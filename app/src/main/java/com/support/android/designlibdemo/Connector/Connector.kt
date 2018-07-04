package com.support.android.designlibdemo.Connector

import okhttp3.*
import okhttp3.logging.*
import retrofit2.*
import retrofit2.converter.gson.*

object Connector {

    private val baseUrl = ""

    init {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logger).build()
        val retrfit = Retrofit.Builder().client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }

}