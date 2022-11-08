package com.example.laundryapp.Models;

import java.math.BigDecimal;
import java.util.Currency;

public class Service {
    private String serviceID;
    private String serviceName;
    private String loadSize;
    private BigDecimal cost;

    public Service(){

    }

    public Service(String serviceID, String serviceName, String loadSize, BigDecimal cost) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.loadSize = loadSize;
        this.cost = cost;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLoadSize() {
        return loadSize;
    }

    public void setLoadSize(String loadSize) {
        this.loadSize = loadSize;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
