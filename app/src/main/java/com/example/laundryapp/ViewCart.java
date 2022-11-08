package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.laundryapp.Models.Cart;
import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ViewCart extends AppCompatActivity {
    RecyclerView recyclerView;
    CartList_Adapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        recyclerView = findViewById(R.id.rv_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        startAdapter();

    }

    private void startAdapter() {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentFirebaseUser.getUid();
        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(FirebaseDatabase.getInstance().getReference().child("Cart").child(userID), Cart.class).build();

        cartAdapter = new CartList_Adapter(options);
        recyclerView.setAdapter(cartAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cartAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cartAdapter.stopListening();
    }
}