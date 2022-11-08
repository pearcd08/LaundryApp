package com.example.laundryapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServiceList_Holder extends RecyclerView.ViewHolder {

    public TextView tv_name, tv_load, tv_price;
    public Button btn_add;

    public ServiceList_Holder(@NonNull View itemView) {
        super(itemView);

        tv_name = itemView.findViewById(R.id.tv_servicecard_servicename);
        tv_load = itemView.findViewById(R.id.tv_servicecard_loadsize);
        tv_price = itemView.findViewById(R.id.tv_servicecard_price);

        btn_add = itemView.findViewById(R.id.btn_servicecard_addtocart);
    }
}
