package com.javaproject.malki.projectstepone.model.entities;

/**
 * describe some address in the world
 * Created by malki on 04-Nov-17.
 */

public class Address {
    private String city;
    private ENUMS.COUNTRY country;
    private int house;
    private int door;

    //constructor
    public Address(String city, ENUMS.COUNTRY country, int house, int door) throws Exception{
        this.setCity(city);
        this.setCountry(country);
        this.setHouse(house);
        this.setDoor(door);
    }
    //copy constructor
    public Address(Address branchAddress) throws Exception
    {
        this.setCity(branchAddress.city);
        this.setCountry(branchAddress.country);
        this.setHouse(branchAddress.house);
        this.setDoor(branchAddress.door);
    }

    public Address() {

    }

    //get and set
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ENUMS.COUNTRY getCountry() {
        return country;
    }

    public void setCountry(ENUMS.COUNTRY country) {
        this.country = country;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) throws Exception {
        if (house < 1)
        {
            throw new Exception("invalid value!");
        }
        this.house = house;
    }


    public int getDoor() {
        return door;
    }

    public void setDoor(int door) throws Exception{
        if (door < 1)
        {
            throw new Exception("invalid value!");
        }
        this.door = door;
    }
    @Override
    public String toString() {
        return String.format("%s, %s, %d",this.country, this.city, this.house);
    }

}
