package com.example.laundryapp;

import static java.lang.Long.parseLong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laundryapp.Models.Service;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.util.Currency;

public class CreateService extends AppCompatActivity implements View.OnClickListener {

    EditText et_name, et_load, et_price;
    Button btn_save, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service);

        et_name = findViewById(R.id.txt_createservice_name);
        et_load = findViewById(R.id.txt_createservice_loadsize);
        et_price = findViewById(R.id.txt_createservice_price);

        btn_back = findViewById(R.id.btn_createservice_back);
        btn_save = findViewById(R.id.btn_createservice_save);

        btn_back.setOnClickListener(this);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==btn_back.getId()){
            startActivity(new Intent(this, EmployeeHome.class));

        }
        if(v.getId()==btn_save.getId()){
            saveService();
        }

    }

    private void saveService() {
        String name = et_name.getText().toString();
        String load = et_load.getText().toString();
        String priceString = et_price.getText().toString();
        Double priceDouble = Double.parseDouble(priceString);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference serviceRef = database.getReference("Services");
        String serviceID = serviceRef.push().getKey();

        Service service = new Service(serviceID, name, load, priceDouble);
        serviceRef.child(serviceID).setValue(service);

        Toast.makeText(this, "Service Added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, EmployeeHome.class));





    }
}