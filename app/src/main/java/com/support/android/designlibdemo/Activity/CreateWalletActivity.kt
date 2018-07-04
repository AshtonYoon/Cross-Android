package com.support.android.designlibdemo.Activity

import android.os.*
import android.support.v7.app.*
import com.support.android.designlibdemo.Connector.*
import com.support.android.designlibdemo.Model.*
import com.support.android.designlibdemo.R
import io.realm.*
import kotlinx.android.synthetic.main.activity_create_wallet.*

class CreateWalletActivity: AppCompatActivity() {

    private var confirmFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_wallet)

        Realm.init(this)

        val symbol = ""

        bt_create_wallet.setOnClickListener {
            if(emptyCheck() && confirmFlag){
                Connector(this).walletAPI
                        .createWallet(  symbol,
                                        et_create_wallet_name.text.toString(),
                                        et_create_wallet_description.text.toString(),
                                        et_create_wallet_password.text.toString(),
                                        rb_create_wallet_major.isChecked,
                                        rb_create_wallet_user_info_open.isChecked )
                        .enqueue(object: Response<WalletFile>(this){
                            override fun setResponseData(code: Int, data: WalletFile?) {
                                data?.let { data ->
                                    val realm = Realm.getDefaultInstance()
                                    realm.executeTransaction {
                                        it.copyFromRealm(data)
                                    }
                                }
                            }
                        })
            }
        }

    }

    private fun emptyCheck(): Boolean{
        return et_create_wallet_name.text.isNotEmpty() && et_create_wallet_description.text.isNotEmpty() && et_create_wallet_password.text.isNotEmpty()
    }

}