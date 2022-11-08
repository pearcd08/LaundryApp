package com.example.laundryapp.Models;

public class Cart {
    private String cartID;
    private String name;
    private String load;
    private Double cost;
    private int quantity;

    public Cart(){

    }

    public Cart(String cartID, String name, String load, Double cost, int quantity) {
        this.cartID = cartID;
        this.name = name;
        this.load = load;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
