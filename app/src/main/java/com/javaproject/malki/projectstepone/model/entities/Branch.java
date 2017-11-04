package com.javaproject.malki.projectstepone.model.entities;

/**
 * this class represents the Take&Go's branch
 * Created by malki on 04-Nov-17.
 */

public class Branch
{
    private Address branchAddress;
    private int parkingSpace;
    private long branchNumber;

    //constructor
    public Branch(Address branchAddress, int parkingSpace, long branchNumber) {
        this.setBranchAddress(branchAddress);
        this.setParkingSpace(parkingSpace);
        this.setBranchNumber(branchNumber);
    }

    //copy constructor
    public Branch(Branch newBranch) {
        this.setBranchAddress(newBranch.branchAddress);
        this.setParkingSpace(newBranch.parkingSpace);
        this.setBranchNumber(newBranch.branchNumber);
    }
    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = new Address(branchAddress);
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public long getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(long branchNumber) {
        this.branchNumber = branchNumber;
    }
    //get and set

}
