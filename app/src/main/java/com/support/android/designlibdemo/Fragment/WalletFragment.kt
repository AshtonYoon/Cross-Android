package com.support.android.designlibdemo.Fragment

import android.os.*
import android.support.v4.app.*
import android.support.v7.widget.*
import android.view.*
import com.bumptech.glide.*
import com.support.android.designlibdemo.Connector.*
import com.support.android.designlibdemo.Model.*
import com.support.android.designlibdemo.R
import kotlinx.android.synthetic.main.view_wallet_cell.view.*

class WalletFragment: Fragment() {

    companion object { val instance = WalletFragment() }

    private lateinit var adapter: WalletFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val recyclerView = RecyclerView(context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = WalletFragmentAdapter().apply { recyclerView.adapter = this }
        return recyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Connector(context!!).walletAPI.walletList.enqueue(object: Response<List<Wallet>>(context!!){
            override fun setResponseData(code: Int, data: List<Wallet>?) {
                data?.let { adapter.dataArr = it; adapter.notifyDataSetChanged() }
            }
        })
    }

}

class WalletFragmentAdapter: RecyclerView.Adapter<WalletFragmentViewHolder>(){

    var dataArr = emptyList<Wallet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletFragmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_wallet_cell, parent, false)
        return WalletFragmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataArr.size
    }

    override fun onBindViewHolder(holder: WalletFragmentViewHolder, position: Int) {
        holder.bind(dataArr[position])
    }

}

class WalletFragmentViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(wallet: Wallet){
        itemView.apply{
            Glide.with(context).load(Connector.baseUrl + "/assets/${wallet.symbol}.png").into(iv_view_wallet_symbol)
            tv_view_wallet_title.text = wallet.name
            tv_view_wallet_coin_symbol.text = wallet.symbol
            tv_view_wallet_coin_money.text = wallet.balance
            tv_view_wallet_local_symbol.text = "KRW"
            tv_view_wallet_local_money.text = wallet.krBalance.toString().substring(0..8)
        }
    }

}