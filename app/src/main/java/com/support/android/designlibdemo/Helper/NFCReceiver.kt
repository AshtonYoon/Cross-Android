package com.support.android.designlibdemo.Helper

import android.app.*
import android.content.*
import android.nfc.*
import android.os.*
import android.util.*
import com.support.android.designlibdemo.Activity.*
import java.util.*

class NFCReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == NfcAdapter.ACTION_NDEF_DISCOVERED){
            val rawMessage = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            val ndefArr = rawMessage.map { it as NdefMessage }
            ndefArr.forEach { Log.e("xxx", it.toString()) }
        }
    }

}

class NFCService: Service(){

    override fun onBind(p0: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timer().schedule(timerTask, 3 * 1000)
        return  START_STICKY
    }

    private val timerTask = object: TimerTask() {
        override fun run() {
            startActivity(Intent(this@NFCService, NFCActivity::class.java))
        }
    }

}