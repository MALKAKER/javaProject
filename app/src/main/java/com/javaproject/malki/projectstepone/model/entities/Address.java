package com.javaproject.malki.projectstepone.model.entities;

/**
 * describe some address in the world
 * Created by malki on 04-Nov-17.
 */

public class Address {
    private String city;
    private String country;
    private int house;
    private int door;

    //constructor
    public Address(String city, String country, int house, int door) {
        this.setCity(city);
        this.setCountry(country);
        this.setHouse(house);
        this.setDoor(door);
    }
    //copy constructor
    public Address(Address branchAddress)
    {
        this.setCity(branchAddress.city);
        this.setCountry(branchAddress.country);
        this.setHouse(branchAddress.house);
        this.setDoor(branchAddress.door);
    }

    //get and set
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }
}
