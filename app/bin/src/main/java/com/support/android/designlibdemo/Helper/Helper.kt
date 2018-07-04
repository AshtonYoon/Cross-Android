package com.support.android.designlibdemo.Helper

import android.content.*
import android.widget.*

object Helper {

    fun showToast(context: Context, msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

}