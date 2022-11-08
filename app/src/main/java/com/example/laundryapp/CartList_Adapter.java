package com.example.laundryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundryapp.Models.Cart;
import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CartList_Adapter extends FirebaseRecyclerAdapter<Cart, CartList_Holder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CartList_Adapter(@NonNull FirebaseRecyclerOptions<Cart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CartList_Holder holder, int position, @NonNull Cart model) {
        holder.tv_name.setText("Name: "+model.getName());
        holder.tv_load.setText("Load: "+model.getLoad());
        holder.tv_price.setText("Price: $"+String.valueOf(model.getCost()));


        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                String userid = currentFirebaseUser.getUid();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference cartRef = database.getReference("Cart");
                DatabaseReference cartRef2 = cartRef.child(userid);
                cartRef2.child(model.getCartID()).removeValue();

            }
        });

    }

    @NonNull
    @Override
    public CartList_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.card_cart,
                parent, false);
        return new CartList_Holder(view);
    }

}
