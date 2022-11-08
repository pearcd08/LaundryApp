package com.example.laundryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laundryapp.Models.Address;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class RegisterUser3 extends AppCompatActivity implements View.OnClickListener {

    EditText et_streetaddress1, et_streetaddress2, et_suburb, et_city;
    String  email, password, firstName, lastName, phone, userid;
    Button btn_back, btn_next;
    LatLng addressLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user3);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            userid = extras.getString("userid");


        }

        et_streetaddress1 = findViewById(R.id.txt_register_streetaddress1);
        et_streetaddress2 = findViewById(R.id.txt_register_streetaddress2);
        et_suburb = findViewById(R.id.txt_register_suburb);
        et_city = findViewById(R.id.txt_register_city);

        btn_back = findViewById(R.id.btn_register3_back);
        btn_next = findViewById(R.id.btn_register3_next);

        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);


        startPlaces();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_back.getId()){
            startActivity(new Intent(this, RegisterUser2.class));
        }
        if(v.getId()==btn_next.getId()){
            nextActivity();
        }

    }

    private void nextActivity() {
        String streetAddress1 = et_streetaddress1.getText().toString();
        String streetAddress2 = et_streetaddress2.getText().toString();
        String suburb = et_suburb.getText().toString();
        String city = et_city.getText().toString();


        if (streetAddress2.isEmpty()) {
            Toast.makeText(this, "Please search for your address", Toast.LENGTH_SHORT).show();
            return;
        }


        else{
            Address address = null;
            if(streetAddress1.length() > 0){
                address = new Address(streetAddress1,streetAddress2,suburb,city,addressLocation);

            }
            else if(streetAddress1.length() == 0){
                address = new Address("",streetAddress2,suburb,city,addressLocation);

            }



            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference userRef = database.getReference("Users");

            userRef.child(userid)
                    .child("Address")
                    .setValue(address);

            Intent intent = new Intent(this, RegisterUser4.class);           ;
            intent.putExtra("userid", userid);
            startActivity(intent);

        }
    }

    private void startPlaces() {
        //Initialise places
        Places.initialize(getApplicationContext(), "AIzaSyDGYwtmPp1374_zw8rVE31FNMMJgXPYFUU");
        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG));


        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onError(@NonNull Status status) {

            }

            @Override
            public void onPlaceSelected(@NonNull Place place) {
                String[] address = place.getAddress().split(",");
                et_streetaddress2.setText(address[0]);
                et_suburb.setText(address[1]);
                et_city.setText(address[2]);
                addressLocation = place.getLatLng();

            }
        });

    }


}