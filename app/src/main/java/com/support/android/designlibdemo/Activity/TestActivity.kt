package com.support.android.designlibdemo.Activity

import android.content.*
import android.os.*
import android.support.v7.app.*
import com.support.android.designlibdemo.Helper.*

class TestActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun startNfcService() = startService(Intent(this, NFCService::class.java))

}