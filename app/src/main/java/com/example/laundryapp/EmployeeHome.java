package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmployeeHome extends AppCompatActivity implements View.OnClickListener {

    Button btn_createService, btn_viewPickups;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);

        btn_createService = findViewById(R.id.btn_employeehome_createservice);
        btn_createService.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_createService.getId()){
            startActivity(new Intent(this, CreateService.class));
        }

    }
}