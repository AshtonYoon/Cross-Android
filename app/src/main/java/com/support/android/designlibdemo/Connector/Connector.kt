package com.support.android.designlibdemo.Connector

import android.content.*
import com.support.android.designlibdemo.Helper.*
import okhttp3.*
import okhttp3.logging.*
import retrofit2.*
import retrofit2.converter.gson.*

public class Connector(context: Context) {

    companion object {
        val baseUrl = ""
    }

    public val friendAPI: FriendService
    public val loginAPI: LoginService
    public val remittanceAPI: RemittanceService
    public val walletAPI: WalletService

    init {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addInterceptor {
                    val token = Helper.getPrefData("token", context)
                    val builder = it.request().newBuilder()
                    builder.header("Authorization", token)
                    it.proceed(builder.build())
                }
                .build()
        val retrfit = Retrofit.Builder().client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        friendAPI = retrfit.create(FriendService::class.java)
        loginAPI = retrfit.create(LoginService::class.java)
        remittanceAPI = retrfit.create(RemittanceService::class.java)
        walletAPI = retrfit.create(WalletService::class.java)

    }

}