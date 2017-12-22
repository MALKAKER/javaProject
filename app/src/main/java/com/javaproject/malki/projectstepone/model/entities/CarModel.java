package com.javaproject.malki.projectstepone.model.entities;

import android.graphics.Color;

/**
 * this class describes the car model,
 * including the properties of the car
 * Created by malki on 04-Nov-17.
 */

public class CarModel {
    private String model;//maybe the model number can be a hash like AS1234?
    private ENUMS.COMPANY carCompany;
    private String modelName;
    private int engineVol;
    private ENUMS.COLORS carColor;
    private boolean isGearBox; // true (hand) false (auto)
    private boolean isLimitMileage;
    //if there is a mileage limitation this field is not empty
    private int mileageNumber;
    private short numberOfSeats;
    private float trunkHeight;
    private float trunkWidth;
    //private int trunkVol; - maybe unnecessary
    private boolean airConditioning;
    private boolean isSafetySystem;
    //if there is a safety system limitation this field is not empty
    private ENUMS.SAFETY safetyType;
    private int pollutionLevel;




    //private functions
    private void ErrorValue(float val) throws Exception
    {
        if( val <= 0)
        {
            throw new Exception("invalid value!\n");
        }
    }
    //constructor
    public CarModel(String model, ENUMS.COMPANY carCompany, String modelName, int engineVol, ENUMS.COLORS carColor, boolean isGearBox,
                    boolean isLimitMileage, short numberOfSeats, float trunkHeight, float trunkWidth, boolean airConditioning,
                    boolean safetySystem, int pollution_level ) throws Exception {
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
        this.setSafetySystem(safetySystem);
        this.setPollution_level(pollution_level);
    }

    //copy constructor
    public CarModel( CarModel newCar) throws Exception {
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
        this.setSafetySystem(newCar.isSafetySystem());
        this.setPollution_level(newCar.getPollution_level());
    }

    public CarModel() {

    }
    //get and set
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ENUMS.COMPANY getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(ENUMS.COMPANY carCompany) {
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

    public void setEngineVol(int engineVol) throws Exception {
        ErrorValue(engineVol);
        this.engineVol = engineVol;
    }

    public ENUMS.COLORS getCarColor() {
        return carColor;
    }

    public void setCarColor(ENUMS.COLORS carColor) {
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

    public void setNumberOfSeats(short numberOfSeats) throws  Exception {
        ErrorValue(numberOfSeats);
        this.numberOfSeats = numberOfSeats;
    }

    public float getTrunkHeight() {
        return trunkHeight;
    }

    public void setTrunkHeight(float trunkHeight) throws Exception {
        ErrorValue(trunkHeight);
        this.trunkHeight = trunkHeight;
    }

    public float getTrunkWidth() {
        return trunkWidth;
    }

    public void setTrunkWidth(float trunkWidth) throws Exception {
        ErrorValue(trunkWidth);
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

    public void setMileageNumber(int mileageNumber) throws Exception {
        ErrorValue(mileageNumber);
        this.mileageNumber = isLimitMileage ? mileageNumber : null;
    }

    public boolean isSafetySystem() {
        return isSafetySystem;
    }

    public ENUMS.SAFETY getSafetyType() {
        return safetyType;
    }

    public void setSafetySystem(boolean safetySystem) {
        isSafetySystem = safetySystem;
    }

    public void setSafetyType(ENUMS.SAFETY safetyType) {
        this.safetyType = isSafetySystem ? safetyType : null;
    }

    public int getPollution_level() {
        return pollutionLevel;
    }

    public void setPollution_level(int pollution_level) throws Exception {
        if(pollution_level > 15 && pollution_level < 1)
        {
            throw new Exception("ERROR: The pollution level is not valid!\n");
        }
        this.pollutionLevel = pollution_level;
    }

    @Override
    public String toString()
    {
        return String.format("Company: %s\nModel: %s\nModel #: %s\nColor: %s\nGear: %s\nNumber Of Seats: %d\n" +
                        "Trunk Volume: %f\nAir Conditioning: %s\nSafety System: %s\n" +
                        "Pollution Level: %d ",
                carCompany.toString(), modelName, model, carColor.toString(), isGearBox==true? "Hand":"Auto",
                numberOfSeats, trunkHeight*trunkWidth,
                airConditioning? "Air Conditioner":"Non", isSafetySystem? getSafetyType().toString():"Non",
                pollutionLevel);
    }
}
