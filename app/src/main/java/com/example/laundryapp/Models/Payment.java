package com.example.laundryapp.Models;

public class Payment {
    private String cardNo;
    private String cardDate;
    private String ccv;

    public Payment(){

    }

    public Payment(String cardNo, String cardDate, String ccv) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
        this.ccv = ccv;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}
