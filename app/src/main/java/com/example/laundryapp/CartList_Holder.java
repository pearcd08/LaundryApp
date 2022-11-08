package com.example.laundryapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartList_Holder extends RecyclerView.ViewHolder {

    public TextView tv_name, tv_load, tv_price;
    public Button btn_remove;

    public CartList_Holder(@NonNull View itemView) {
        super(itemView);

        tv_name = itemView.findViewById(R.id.tv_cart_servicename);
        tv_load = itemView.findViewById(R.id.tv_cart_loadsize);
        tv_price = itemView.findViewById(R.id.tv_cart_price);

        btn_remove = itemView.findViewById(R.id.btn_cart_remove);
    }
}
