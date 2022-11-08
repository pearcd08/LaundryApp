package com.example.laundryapp.Models;

import com.google.android.gms.maps.model.LatLng;

public class Pickup {
    private String userID;
    private String userName;
    private String userAddress;
    private LatLng userLocation;
    private String pickupDate;
    private String pickupTime;
    private String price;
    private String status;

    public Pickup(){

    }

    public Pickup(String userID, String userName, String userAddress, LatLng userLocation, String pickupDate, String pickupTime, String price, String status) {
        this.userID = userID;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userLocation = userLocation;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.price = price;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public LatLng getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(LatLng userLocation) {
        this.userLocation = userLocation;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
