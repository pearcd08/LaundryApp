package com.example.laundryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser1 extends AppCompatActivity implements View.OnClickListener {
    EditText et_email, et_password1, et_password2;
    Button btn_back, btn_next;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user1);

        fAuth = FirebaseAuth.getInstance();

        et_email = findViewById(R.id.txt_register_email);
        et_password1 = findViewById(R.id.txt_register_password1);
        et_password2 = findViewById(R.id.txt_register_password2);

        btn_back = findViewById(R.id.btn_register1_back);
        btn_next = findViewById(R.id.btn_register1_next);

        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_back.getId()){
            startActivity(new Intent(this, MainActivity.class));
        }
        if(v.getId()==btn_next.getId()){
            nextActivity();
        }
    }

    private void nextActivity() {
        String email = et_email.getText().toString().trim();
        String password1 = et_password1.getText().toString().trim();
        String password2 = et_password2.getText().toString().trim();

        if (email.isEmpty()) {
            et_email.setError("Please enter the email address");
            et_email.requestFocus();
            return;
        }


        //Email address validation
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Please provide valid email address");
            et_email.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            et_password1.setError("Please provide a password");
            et_password1.requestFocus();
            return;
        }

        if (password1.length() < 6) {
            et_password1.setError("Password must be atleast 6 characters");
            et_password1.requestFocus();
            return;
        }

        if(!password2.equals(password1)){
            et_password2.setError("Passwords do not match");
            et_password2.requestFocus();
            return;

        }
        else{
//hello
            fAuth.createUserWithEmailAndPassword(email, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        String userID = fAuth.getCurrentUser().getUid();
                        Intent intent = new Intent(RegisterUser1.this, RegisterUser2.class);
                        intent.putExtra("userid", userID);
                        startActivity(intent);


                    }
                    else{
                        et_email.setError("That email is already registered");
                        et_email.requestFocus();
                    }

                }
            });


        }
    }
}