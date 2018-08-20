package com.support.android.designlibdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.support.android.designlibdemo.Model.Wallet;
import com.support.android.designlibdemo.R;
import com.support.android.designlibdemo.ViewHolders.WalletViewHolder;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter<WalletViewHolder> {
    private ArrayList<Wallet> mWallets;
    Context mContext;
    public WalletAdapter(ArrayList mWallets) {
        this.mWallets = mWallets;
    }

    @Override
    public WalletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_wallet_cell, parent, false);
        mContext = parent.getContext();
        WalletViewHolder holder = new WalletViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(WalletViewHolder holder, final int position) {
        // 해당 position 에 해당하는 데이터 결합
        holder.walletName.setText(mWallets.get(position).getName());
    }
    
    @Override
    public int getItemCount() {
        return mWallets.size();
    }
}
