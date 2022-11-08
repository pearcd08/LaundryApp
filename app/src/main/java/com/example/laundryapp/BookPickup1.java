package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.laundryapp.Models.Cart;
import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BookPickup1 extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference serviceRef;
    private RecyclerView recyclerView;
    private String userID;
    ServiceList_Adapter serviceAdapter;
    private Button cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pickup);

        //Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        userID = currentUser.getUid();
        //Firebase Realtime Database
        database = FirebaseDatabase.getInstance();
        serviceRef = database.getReference("Services");

        recyclerView = findViewById(R.id.rv_services);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cart = (Button) findViewById(R.id.btn_bookpickup_viewCart);
        cart.setOnClickListener(this);
        startAdapter();


    }



    private void startAdapter() {
        FirebaseRecyclerOptions<Service> options = new FirebaseRecyclerOptions.Builder<Service>().setQuery(FirebaseDatabase.getInstance().getReference().child("Services"), Service.class).build();

        serviceAdapter = new ServiceList_Adapter(options, this);
        recyclerView.setAdapter(serviceAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        serviceAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        serviceAdapter.stopListening();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == cart.getId()) {
            Intent intent = new Intent(this, ViewCart.class);
            startActivity(intent);

        }

    }
}