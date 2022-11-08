package com.example.laundryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundryapp.Models.Cart;
import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ServiceList_Adapter extends FirebaseRecyclerAdapter<Service, ServiceList_Holder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ServiceList_Adapter(@NonNull FirebaseRecyclerOptions<Service> options, Context context) {
        super(options);

    }


    @Override
    protected void onBindViewHolder(@NonNull ServiceList_Holder holder, int position, @NonNull Service model) {
        holder.tv_name.setText("Name: " + model.getServiceName());
        holder.tv_load.setText("Load: " + model.getLoadSize());
        holder.tv_price.setText("Price: $" + String.valueOf(model.getCost()));

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                String userid = currentFirebaseUser.getUid();

                Cart cart = new Cart(model.getServiceID(), model.getServiceName(), model.getLoadSize(), model.getCost(), 1);
                String cartID = model.getServiceID();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference cartRef = database.getReference("Cart");
                DatabaseReference cartRef2 = cartRef.child(userid);
                cartRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(cartID).exists()) {
                            int quantity = snapshot.child(cartID).child("quantity").getValue(Integer.class);
                            quantity++;
                            cartRef2.child(cartID).child("quantity").setValue(quantity);



                        }
                        else{
                            cartRef2.child(cartID).setValue(cart);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });


    }

    @NonNull
    @Override
    public ServiceList_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_service, parent, false);
        return new ServiceList_Holder(view);
    }
}
