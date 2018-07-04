package com.support.android.designlibdemo.Activity

import android.os.*
import android.support.v7.app.*
import android.support.v7.widget.*
import android.view.*
import com.bumptech.glide.*
import com.support.android.designlibdemo.Connector.*
import com.support.android.designlibdemo.Model.*
import com.support.android.designlibdemo.R
import kotlinx.android.synthetic.main.activity_select_coin.*
import kotlinx.android.synthetic.main.view_select_coin_list_cell.view.*

class SelectCoinActivity: AppCompatActivity() {

    lateinit var adapter: SelectCoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_coin)

        rv_select_coin.layoutManager = LinearLayoutManager()
        adapter = SelectCoinAdapter().apply { rv_select_coin.adapter = this }



    }

}

class SelectCoinAdapter: RecyclerView.Adapter<SelectCoinViewHolder>(){

    var dataArr = emptyList<Coin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_select_coin_list_cell, parent, false)
        return SelectCoinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataArr.size
    }

    override fun onBindViewHolder(holder: SelectCoinViewHolder, position: Int) {
        holder.bind(dataArr[position])
    }

}

class SelectCoinViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(coin: Coin){
        itemView.apply {
            Glide.with(context).load(Connector.baseUrl + "/assets/${coin.symbol}.png").into(iv_select_coin_symbol)
            tv_select_coin_title.text = coin.symbol + " / " + coin.name
        }
    }

}