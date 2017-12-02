package com.javaproject.malki.projectstepone.model.backend;

import android.content.ContentValues;

import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;
import com.javaproject.malki.projectstepone.model.entities.Order;

import java.util.List;

/**
 * An interface that defines the behaviour of the DB
 * Created by Malki on 12-Nov-17.
 */

public interface DB_Manager {
    //Check if the user is already exist in the data base
    public boolean ClientExist(String ID);
    //Check if the car-model is already exist in the data base
    public boolean ModelExist(String ID);
    //Check if the car is already exist in the data base
    public boolean CarExist(String ID);
    //Check if the user is already exist in the data base and return the object
    public Client GetClient(String ID) throws Exception;
    //Check if the car-model is already exist in the data base and return the object
    public CarModel GetModel(String ID) throws Exception;
    //Check if the car is already exist in the data base and return the object
    public Car GetCar(String ID) throws Exception;
    //Add client to data base
    public String AddClient(ContentValues values) throws Exception;
    //Add model into data base??
    public String AddModel(ContentValues values) throws Exception;
    //Add Car into data base
    public String AddCar(ContentValues values) throws Exception;
    //Add Order into data base
    public String AddOrder(ContentValues values) throws Exception;
    //Add Branch into data base
    public String AddBranch(ContentValues values) throws Exception;
    //Update fuel quantity
    public ENUMS.FUEL_MODE UpdateQuantity(float start, float end, float newFuel, String carModel) throws Exception;
    //Returns list of car's model
    public List<CarModel> GetModels();
    //Returns list of all users
    public List<Client> GetClients();
    //TODO extand the methods that retrieve the client according to some condition
    //Returns list of branches
    public List<Branch> GetBranches();
    //todo extand methods that will retrieve the branches according to some criteria
    //Returns list of cars
    public List<Car> GetCar();
    //todo extand methods that will retrieve the Cars according to some criteria
    //to some statistics - return all the orders
    public List<Order> GetOrders();
    //todo extand methods that will retrieve the orderss according to some criteria
}
