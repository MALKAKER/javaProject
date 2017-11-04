package com.javaproject.malki.projectstepone.model.entities;

/**
 * the class represents a cliens in the  leasing company
 * Created by malki on 04-Nov-17.
 */

public class Client
{
    private String firstName;
    private String lastName;
    private String clientID;
    private long phoneNumber;
    private String email;
    private long creditCard;

    //constructor
    public Client(String firstName, String lastName, String clientID, long phoneNumber, String email, long creditCard) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setClientID(clientID);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setCreditCard(creditCard);
    }

    //copy constructor
    public Client(Client newClient) {
        this.setFirstName(newClient.firstName);
        this.setLastName(newClient.lastName);
        this.setClientID(newClient.clientID);
        this.setPhoneNumber(newClient.phoneNumber);
        this.setEmail(newClient.email);
        this.setCreditCard(newClient.creditCard);
    }

    //empty client is not allowed
    //get and set
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }
}
