package com.javaproject.malki.projectstepone.model.entities;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * this class describes the car's order details
 * Created by malki on 04-Nov-17.
 */

public class Order
{
    private int clientNumber;
    private boolean orderStatus; //true = open , false = close
    private int carNumber;
    private Date startRent;
    private Date endRent;
    private float startMileage;
    private float endMileage;
    private boolean isFuel;
    private float fuelVol = 0;
    private DecimalFormat billAmount;
    private  int orderNumber;

    //constructor
    public Order(int clientNumber, boolean orderStatus, int carNumber, Date startRent, Date endRent, float startMileage, float endMileage, boolean isFuel, DecimalFormat billAmount, int orderNumber) {
        this.setClientNumber(clientNumber);
        this.setOrderStatus(orderStatus);
        this.setCarNumber(carNumber);
        this.setStartRent(startRent);
        this.setEndRent(endRent);
        this.setStartMileage(startMileage);
        this.setEndMileage(endMileage);
        this.setFuel(isFuel);
        this.setBillAmount(billAmount);
        this.setOrderNumber(orderNumber);
    }

    // copy constructor
    public Order( Order newOrder){
        this.setClientNumber(newOrder.clientNumber);
        this.setOrderStatus(newOrder.orderStatus);
        this.setCarNumber(newOrder.carNumber);
        this.setStartRent(newOrder.startRent);
        this.setEndRent(newOrder.endRent);
        this.setStartMileage(newOrder.startMileage);
        this.setEndMileage(newOrder.endMileage);
        this.setFuel(newOrder.isFuel);
        this.setBillAmount(newOrder.billAmount);
        this.setOrderNumber(newOrder.orderNumber);
    }

    //get and set
    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public Date getStartRent() {
        return startRent;
    }

    public void setStartRent(Date startRent) {
        this.startRent = startRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endtRent) {
        this.endRent = endtRent;
    }

    public float getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(float startMileage) {
        this.startMileage = startMileage;
    }

    public float getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(float endMileage) {
        this.endMileage = endMileage;
    }

    public boolean isFuel() {
        return isFuel;
    }

    public void setFuel(boolean fuel) {
        isFuel = fuel;
    }

    public float getFuelVol() {
        return fuelVol;
    }

    public void setFuelVol(float fuelVol){
        this.fuelVol =isFuel()? fuelVol : 0;
    }

    public DecimalFormat getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(DecimalFormat billAmount) {
        this.billAmount = billAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
