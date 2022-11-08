package com.example.laundryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laundryapp.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser2 extends AppCompatActivity implements View.OnClickListener {
    EditText et_firstName, et_lastName, et_phone;
    Button btn_back, btn_next;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user2);

        et_firstName = findViewById(R.id.txt_register_firstname);
        et_lastName = findViewById(R.id.txt_register_lastname);
        et_phone = findViewById(R.id.txt_register_phone);


        btn_back = findViewById(R.id.btn_register2_back);
        btn_next = findViewById(R.id.btn_register2_next);

        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            userid = extras.getString("userid");

        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_back.getId()) {
            startActivity(new Intent(this, RegisterUser1.class));
        }
        if (v.getId() == btn_next.getId()) {
            nextActivity();
        }
    }

    private void nextActivity() {
        String firstName = et_firstName.getText().toString().trim();
        String lastName = et_lastName.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();

        if (firstName.isEmpty()) {
            et_firstName.setError("Please enter your First Name");
            et_firstName.requestFocus();
            return;
        }

        if (firstName.isEmpty()) {
            et_lastName.setError("Please enter your First Name");
            et_lastName.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            et_phone.setError("Please enter Phone Number");
            et_phone.requestFocus();
            return;
        } else {
            User user = new User(userid, firstName, lastName, phone);

            FirebaseDatabase.getInstance().getReference("Users")
                    .child(userid)
                    .setValue(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(RegisterUser2.this, RegisterUser3.class);
                                intent.putExtra("userid", userid);
                                startActivity(intent);

                            }


                        }
                    });
        }
    }
}