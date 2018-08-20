package com.support.android.designlibdemo.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.support.android.designlibdemo.R;

public class WalletViewHolder extends RecyclerView.ViewHolder {
    public TextView walletName;

    public WalletViewHolder(View itemView){
        super(itemView);

        walletName = itemView.findViewById(R.id.tv_view_wallet_title);
    }
}
