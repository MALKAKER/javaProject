package com.javaproject.malki.projectstepone.model.DataSource;
import android.support.annotation.NonNull;

import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * storage the list only at lists
 * Created by malki on 12-Nov-17.
 */

public class List_DB {
    static List<Client> clients;
    static List<Car> cars;
    static List<CarModel> carModels;
    static List<Order> orders;
    static List<Branch> branches;

    //initialize only once
    static  {
        clients = new ArrayList<>();
        cars = new ArrayList<>();
        carModels = new ArrayList<>();
        orders = new ArrayList<>();
        branches = new ArrayList<>();
    }
}
