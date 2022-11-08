package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laundryapp.Models.Address;
import com.example.laundryapp.Models.Payment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser4 extends AppCompatActivity implements View.OnClickListener {
    EditText et_cardNo, et_date, et_ccv;
    Button btn_back, btn_confirm;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user4);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            userid = extras.getString("userid");


        }

        et_cardNo = findViewById(R.id.txt_register_creditcard);
        et_date = findViewById(R.id.txt_register_carddate);
        et_ccv = findViewById(R.id.txt_register_cardccv);

        btn_back = findViewById(R.id.btn_register4_back);
        btn_confirm = findViewById(R.id.btn_register4_confirm);
        btn_back.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_back.getId()){
            startActivity(new Intent(this, RegisterUser3.class));
        }
        if(v.getId()==btn_confirm.getId()){
            nextActivity();
        }

    }

    private void nextActivity() {
        String cardNo = et_cardNo.getText().toString();
        String date = et_date.getText().toString();
        String ccv = et_ccv.getText().toString();

;


        if (cardNo.length() < 16) {
            et_cardNo.setError("Please enter all 16 digits");
            et_cardNo.requestFocus();
            return;
        }

        if (date.length() < 4) {
            et_date.setError("Please enter all 4 digits of date");
            et_date.requestFocus();
            return;
        }
        if (ccv.length() < 3) {
            et_ccv.setError("Please enter all 3 digits of ccv");
            et_ccv.requestFocus();
            return;
        }

        else{

          Payment payment = new Payment(cardNo, date, ccv);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference userRef = database.getReference("Users");
            DatabaseReference paymentRef = userRef.child(userid).child("Payment");
            String paymentID = paymentRef.push().getKey();
            paymentRef.child(paymentID).setValue(payment);
            Toast.makeText(this, "Welcome to Fresh Socks!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);          ;

            startActivity(intent);

        }

    }
}