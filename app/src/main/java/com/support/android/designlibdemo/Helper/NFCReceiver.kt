package com.support.android.designlibdemo.Helper

import android.content.*
import android.nfc.*
import android.util.*

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