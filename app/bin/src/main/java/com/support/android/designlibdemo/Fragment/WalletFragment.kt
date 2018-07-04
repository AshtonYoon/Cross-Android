package com.support.android.designlibdemo.Fragment

import android.os.*
import android.support.v4.app.*
import android.support.v7.widget.*
import android.view.*
import com.support.android.designlibdemo.*

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

    }


}

class WalletFragmentAdapter: RecyclerView.Adapter<WalletFragmentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletFragmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_wallet_cell, parent, false)
        return WalletFragmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: WalletFragmentViewHolder, position: Int) {

    }

}

class WalletFragmentViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(){
        itemView.let{

        }
    }

}