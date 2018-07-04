package com.support.android.designlibdemo.Fragment

import android.os.*
import android.support.v4.app.*
import android.support.v7.widget.*
import android.view.*
import com.support.android.designlibdemo.*

class TransactionFragment: Fragment() {

    private lateinit var adapter: TransactionAdapter

    companion object { val instance = TransactionFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val recyclerView = RecyclerView(context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TransactionAdapter().apply { recyclerView.adapter = this }
        return recyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}

class TransactionAdapter: RecyclerView.Adapter<TransactionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_transaction_cell, parent, false)
        return TransactionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

    }
}

class TransactionViewHolder(view: View): RecyclerView.ViewHolder(view){



}