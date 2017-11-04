package com.javaproject.malki.projectstepone.model.entities;

import android.graphics.Color;

/**
 * this class describing the car model,
 * including the properties of the car
 * Created by malki on 04-Nov-17.
 */

public class CarModel {
    private int model;//maybe the model number can be a hash like AS1234?
    private String carCompany;
    private String modelName;
    private int engineVol;
    private Color carColor;
    private boolean isGearBox; // true (hand) false (auto)
    private boolean isLimitMileage;
    //if there is a mileage limitation this field is not empty
    private int mileageNumber;
    private short numberOfSeats;
    private float trunkHeight;
    private float trunkWidth;
    //private int trunkVol; - maybe unnecessary
    private boolean airConditioning;

    //constructor
    public CarModel(int model, String carCompany, String modelName, int engineVol, Color carColor, boolean isGearBox, boolean isLimitMileage, short numberOfSeats, float trunkHeight, float trunkWidth, boolean airConditioning) {
        this.setModel(model);
        this.setCarCompany(carCompany);
        this.setModelName(modelName);
        this.setEngineVol(engineVol);
        this.setCarColor(carColor);
        this.setGearBox(isGearBox);
        this.setLimitMileage(isLimitMileage);
        this.setNumberOfSeats(numberOfSeats);
        this.setTrunkHeight(trunkHeight);
        this.setTrunkWidth(trunkWidth);
        this.setAirConditioning(airConditioning);
    }

    //copy constructor
    public CarModel( CarModel newCar) {
        this.setModel(newCar.getModel());
        this.setCarCompany(newCar.getCarCompany());
        this.setModelName(newCar.getModelName());
        this.setEngineVol(newCar.getEngineVol());
        this.setCarColor(newCar.getCarColor());
        this.setGearBox(newCar.isGearBox());
        this.setLimitMileage(newCar.isLimitMileage());
        this.setNumberOfSeats(newCar.getNumberOfSeats());
        this.setTrunkHeight(newCar.getTrunkHeight());
        this.setTrunkWidth(newCar.getTrunkWidth());
        this.setAirConditioning(newCar.isAirConditioning());
    }

    //get and set
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(int engineVol) {
        this.engineVol = engineVol;
    }

    public Color getCarColor() {
        return carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public boolean isGearBox() {
        return isGearBox;
    }

    public void setGearBox(boolean gearBox) {
        isGearBox = gearBox;
    }

    public boolean isLimitMileage() {
        return isLimitMileage;
    }

    public void setLimitMileage(boolean limitMileage) {
        isLimitMileage = limitMileage;
    }

    public short getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(short numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public float getTrunkHeight() {
        return trunkHeight;
    }

    public void setTrunkHeight(float trunkHeight) {
        this.trunkHeight = trunkHeight;
    }

    public float getTrunkWidth() {
        return trunkWidth;
    }

    public void setTrunkWidth(float trunkWidth) {
        this.trunkWidth = trunkWidth;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public int getMileageNumber() {
        return mileageNumber;
    }

    public void setMileageNumber(int mileageNumber) {
        this.mileageNumber = isLimitMileage ? mileageNumber : null;
    }
}
