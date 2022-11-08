package com.example.laundryapp.Models;

import com.google.android.gms.maps.model.LatLng;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String suburb;
    private String city;
    private LatLng longLat;

    public Address(){

    }

    public Address(String addressLine1, String addressLine2, String suburb, String city, LatLng longLat) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.suburb = suburb;
        this.city = city;
        this.longLat = longLat;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LatLng getLongLat() {
        return longLat;
    }

    public void setLongLat(LatLng longLat) {
        this.longLat = longLat;
    }
}
