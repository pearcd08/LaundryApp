package com.example.laundryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ServiceList_Adapter extends FirebaseRecyclerAdapter<Service, ServiceList_Holder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ServiceList_Adapter(@NonNull FirebaseRecyclerOptions<Service> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull ServiceList_Holder holder, int position, @NonNull Service model) {
        holder.tv_name.setText(model.getServiceName());
        holder.tv_load.setText(model.getLoadSize());
        holder.tv_price.setText(String.valueOf(model.getCost()));

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //add to cart


            }
        });


    }

    @NonNull
    @Override
    public ServiceList_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.card_service,
                parent, false);
        return new ServiceList_Holder(view);
    }
}
