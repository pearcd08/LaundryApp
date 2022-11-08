package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_bookPickup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        btn_bookPickup = findViewById(R.id.btn_userhome_bookpickup);
        btn_bookPickup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_bookPickup.getId()){
            startActivity(new Intent(this, BookPickup1.class));
        }

    }
}