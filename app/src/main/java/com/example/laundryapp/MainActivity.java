package com.example.laundryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_email, et_password;
    Button btn_login, btn_register, btn_test;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        et_email = findViewById(R.id.txt_login_email);
        et_password = findViewById(R.id.txt_login_password);

        btn_login = findViewById(R.id.btn_login_login);
        btn_register = findViewById(R.id.btn_login_register);
        btn_test = findViewById(R.id.testaddress);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_login.getId()) {
            userLogin();
        }
        if (v.getId() == btn_register.getId()) {
            startActivity(new Intent(this, RegisterUser1.class));
        }
        if (v.getId() == btn_test.getId()){
            startActivity(new Intent(this, RegisterUser3.class));


        }

    }

    private void userLogin() {
        //String email = etEmailAddress.getText().toString().trim();
        //String password = etPassword.getText().toString().trim();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (email.isEmpty()) {
            et_email.setError("Please enter Email");
            et_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Please enter a valid Email!");
            et_email.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            et_email.setError("Please enter Password");
            et_email.requestFocus();
            return;
        }




        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                mAuth.getCurrentUser();

                startActivity(new Intent(MainActivity.this, UserHomeActivity.class));
            } else {
                Toast.makeText(MainActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
            }

        });
    }


}