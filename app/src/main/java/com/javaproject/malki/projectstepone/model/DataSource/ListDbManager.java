package com.javaproject.malki.projectstepone.model.DataSource;

import android.content.ContentValues;

import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DB_Manager;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;
import com.javaproject.malki.projectstepone.model.entities.Order;

import java.util.List;

import static com.javaproject.malki.projectstepone.model.DataSource.List_DB.branches;
import static com.javaproject.malki.projectstepone.model.DataSource.List_DB.carModels;
import static com.javaproject.malki.projectstepone.model.DataSource.List_DB.cars;
import static com.javaproject.malki.projectstepone.model.DataSource.List_DB.clients;
import static com.javaproject.malki.projectstepone.model.DataSource.List_DB.orders;
import static com.javaproject.malki.projectstepone.model.backend.ConstCars.ContentValuesToCar;
import static com.javaproject.malki.projectstepone.model.backend.ConstCars.ContentValuesToCarModel;
import static com.javaproject.malki.projectstepone.model.backend.ConstCars.ContentValuesToClient;

/**
 * the class manage data's storage and retrievement
 * Created by malki on 20-Nov-17.
 */

public class ListDbManager implements DB_Manager{

    /*
    * ClientExist: checks if client exist
    * */
    @Override
    public boolean ClientExist(String ID) {
        for (Client c:List_DB.clients) {
            if(c.getClientID() == ID)
            {
                return true;
            }
        }
        return false;
    }
    /*
    * ModelExist: checks if model exist
    * */
    @Override
    public boolean ModelExist(String details) {
        for (CarModel c:List_DB.carModels) {
            if(c.toString() == details)
            {
                return true;
            }
        }
        return false;
    }

    /*
    * CarExist: checks if car exist
    * */
    @Override
    public boolean CarExist(String newLicencePlate) {
        for (Car c:List_DB.cars) {
            if(c.toString() == newLicencePlate)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Client GetClient(String ID) throws Exception {
        for (Client c:List_DB.clients) {
            if(c.getClientID() == ID)
            {
                return c;
            }
        }
        throw new Exception("ERROR: The client doesn't exist!\n");
    }

    @Override
    public CarModel GetModel(String details) throws Exception {
        for (CarModel c:List_DB.carModels) {
            if(c.toString() == details)
            {
                return c;
            }
        }
        throw new Exception("ERROR: The model doesn't exist!\n");
    }

    @Override
    public Car GetCar(String newLicencePlate) throws Exception {
        for (Car c:List_DB.cars) {
            if(c.toString() == newLicencePlate)
            {
                return c;
            }
        }
        throw new Exception("ERROR: The car doesn't exist!\n");
    }

    /*
    * AddClient: adds client to list
    * */
    @Override
    public String AddClient(ContentValues newClient) throws Exception {
        if(!ClientExist(newClient.getAsString(ConstCars.ClientConst.CLIENT_ID)))
        {
            Client client = ContentValuesToClient(newClient);
            (List_DB.clients).add(client);
        }
        else
        {
            throw new Exception("ERROR: This client is already exist in the DB.\n");
        }
        return null;
    }
    /*
    * AddModel: adds model to list
    * */
    @Override
    public String AddModel(ContentValues carModel) throws Exception {
        if(!ModelExist(carModel.toString()))
        {
            CarModel model = ContentValuesToCarModel(carModel);
            (List_DB.carModels).add(model);
        }
        else
        {
            throw new Exception("ERROR: This car-model is already exist in the DB.\n");
        }
        return null;
    }

    @Override
    public String AddCar(ContentValues car) throws Exception {
        if (ModelExist(car.getAsString(ConstCars.CarConst.MODEL_TYPE)) && !CarExist(car.getAsString(ConstCars.CarConst.LICENCE_NUMBER)))
        {
            Car c = ContentValuesToCar(car);
            (List_DB.cars).add(c);
        }
        else
        {
            throw new Exception("ERROR: That car is already exist in the DB.\n");
        }
        return null;
    }

    @Override
    public String AddOrder(ContentValues order) throws Exception {
        return null;
    }

    @Override
    public String AddBranch(ContentValues branch) throws Exception {
        return null;
    }

    @Override
    public ENUMS.FUEL_MODE UpdateQuantity(float start, float end, float newFuel, String licencePlate) throws Exception {
        float quantity = (start-end) * 11 - newFuel;
        ENUMS.FUEL_MODE[] fuelLevel = ENUMS.FUEL_MODE.values();
        Car car = GetCar(licencePlate);
        ENUMS.FUEL_MODE tmp = car.getFuelMode();
        int index ;
        for (index = 0; index < fuelLevel.length; index++)
        {
            if(fuelLevel[index] == car.getFuelMode()){break;}
        }
        //over 22 liter the fuel level decreases in one degree - to ask the lecturer what to do
        //if the client waste a lot fuel and fill the cell by himself- maybe add a field:(
        if(quantity > 22)
        {
            //if the function returns null its an error
            return index > 0 ?  fuelLevel[index - 1] : null;
        }
        return fuelLevel[index];
    }

    /*
    * GetModels() retrieve all models are existed in the system
    * */
    @Override
    public List<CarModel> GetModels() {
        return carModels;
    }
    /*
    * GetClients() retrieve all clients are existed in the system
    * */
    @Override
    public List<Client> GetClients() {
        return clients;
    }
    /*
    * GetBranches() retrieve all branches are existed in the system
    * */
    @Override
    public List<Branch> GetBranches() {
        return branches;
    }
    /*
    * GetCar() retrieve all cars are existed in the system
    * */
    @Override
    public List<Car> GetCar() {
        return cars;
    }
    /*
    * I added - GetOrders() retrieve all orders are existed in the system
    * */
    @Override
    public List<Order> GetOrders() {
        return orders;
    }
}
