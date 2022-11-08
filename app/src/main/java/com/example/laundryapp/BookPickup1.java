package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.laundryapp.Models.Service;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookPickup1 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference serviceRef;
    private RecyclerView recyclerView;
    private String userID;
    ServiceList_Adapter serviceAdapter;


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

        FirebaseRecyclerOptions<Service> options = new FirebaseRecyclerOptions
                .Builder<Service>().
                setQuery(FirebaseDatabase.getInstance()
                        .getReference().child("Services"), Service.class).build();

        serviceAdapter = new ServiceList_Adapter(options);
        recyclerView.setAdapter(serviceAdapter);




    }
}