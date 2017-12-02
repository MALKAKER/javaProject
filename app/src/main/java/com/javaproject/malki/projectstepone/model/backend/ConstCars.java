package com.javaproject.malki.projectstepone.model.backend;

import android.content.ContentValues;

import com.javaproject.malki.projectstepone.model.entities.Address;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;
import com.javaproject.malki.projectstepone.model.entities.Order;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * help class to convert and storage the data as content value
 * Created by malki on 11-Nov-17.
 */
// A conversion from object oriented into contentValues
public class ConstCars {
    public static class AddressConst
    {
        public static String CITY = "city";
        public static String COUNTRY ="country";
        public static String HOUSE = "house";
        public static String DOOR = "door";
    }
    public static class BranchConst
    {
        public static String BRANCH_ADDRESS = "branchAddress";
        public static String PARKING_SPACE = "parkingSpace";
        public static String BRANCH_NUMBER = "branchNumber";
    }
    public static class CarConst
    {
        public static String LOCATION_NUMBER = "locationNumber";
        public static String MODEL_TYPE = "modelType";
        public static String MILEAGE = "mileage";
        public static String LICENCE_NUMBER = "licencePlate";
        public static String FUEL = "fuelMode";
    }
    public static class CarModelConst
    {
        public static String MODEL = "model";
        public static String CAR_COMPANY = "carCompany";
        public static String MODEL_NAME = "modelName";
        public static String ENGINE_VOL = "engineVol";
        public static String CAR_COLOR = "carColor";
        public static String IS_GEAR = "isGearBox";
        public static String IS_LIMIT = "isLimitMileage";
        public static String MILEAGE_NUMBER = "mileageNumber";
        public static String NUMBER_OF_SEATS = "numberOfSeats";
        public static String TRUNK_HEIGHT = "trunkHeight";
        public static String TRUNK_WIDTH = "trunkWidth";
        public static String AIR_CONDITIONER = "airConditioning";
        public static String IS_SAFETY = "isSafetySystem";
        public static String SAFETY_TYPE = "safetyType";
        public static String POLLUTION_LEVEL = "pollutionLevel";
    }
    public static class ClientConst
    {
        public static String FIRST_NAME = "firstName";
        public static String LAST_NAME = "lastName";
        public static String CLIENT_ID = "clientID";
        public static String PHONE_NUMBER = "phoneNumber";
        public static String EMAIL = "email";
        public static String CREDIT_CARD = "creditCard";
        public static String USER_NAME = "userName";
        public static String PASSWORD = "password";
    }
    public static class OrderConst
    {
        public static String ORDER_NUMBER = "orderNumber" ;
        public static String CLIENT_NUMBER = "clientNumber";
        public static String ORDER_STATUS = "orderStatus";
        public static String CAR_NUMBER = "carNumber";
        public static String START_RENT = "startRent";
        public static String END_RENT = "endRent";
        public static String START_MILEAGE = "startMileage";
        public static String END_MILEAGE = "endMileage";
        public static String IS_FUEL = "isFuel";
        public static String FUEL_VOL = "fuelVol" ;
        public static String BILL_AMOUNT = "billAmount";
    }
    //methods that get object oriented items and return contentValues
    public static ContentValues AddressToContentValues (Address address)
    {
        ContentValues cv = new ContentValues();
        cv.put(AddressConst.CITY, address.getCity());
        cv.put(AddressConst.COUNTRY, String.valueOf(address.getCountry()));//what is value of?
        cv.put(AddressConst.HOUSE, address.getHouse());
        cv.put(AddressConst.DOOR, address.getDoor());
        return cv;
    }
    public static ContentValues BranchToContentValues (Branch branch)
    {
        ContentValues cv = new ContentValues();
        cv.put(BranchConst.BRANCH_ADDRESS, String.valueOf((AddressToContentValues(branch.getBranchAddress())).valueSet()));
        cv.put(BranchConst.BRANCH_NUMBER, branch.getBranchNumber());//what is value of?
        cv.put(BranchConst.PARKING_SPACE, branch.getParkingSpace());
        return cv;
    }
    public static ContentValues CarToContentValues (Car car)
    {
        ContentValues cv = new ContentValues();
        cv.put(CarConst.LICENCE_NUMBER, car.getLicencePlate());
        cv.put(CarConst.LOCATION_NUMBER, car.getLocationNumber());//what is value of?
        cv.put(CarConst.MILEAGE, car.getMileage());
        cv.put(CarConst.MODEL_TYPE, String.valueOf(car.getModelType()));
        cv.put(CarConst.MODEL_TYPE, String.valueOf(car.getFuelMode()));
        return cv;
    }
    public static ContentValues CarModelToContentValues (CarModel carModel)
    {
        ContentValues cv = new ContentValues();
        cv.put(CarModelConst.AIR_CONDITIONER, carModel.isAirConditioning());
        cv.put(CarModelConst.CAR_COLOR, String.valueOf(carModel.getCarColor()));//what is value of?
        cv.put(CarModelConst.CAR_COMPANY, String.valueOf(carModel.getCarCompany()));
        cv.put(CarModelConst.ENGINE_VOL, carModel.getEngineVol());
        cv.put(CarModelConst.IS_GEAR, carModel.isGearBox());
        cv.put(CarModelConst.IS_LIMIT, carModel.isLimitMileage());
        cv.put(CarModelConst.IS_SAFETY, carModel.isSafetySystem());
        cv.put(CarModelConst.MILEAGE_NUMBER, carModel.getMileageNumber());
        cv.put(CarModelConst.MODEL, carModel.getModel());
        cv.put(CarModelConst.MODEL_NAME, carModel.getModelName());
        cv.put(CarModelConst.TRUNK_HEIGHT, carModel.getTrunkHeight());
        cv.put(CarModelConst.TRUNK_WIDTH, carModel.getTrunkWidth());
        cv.put(CarModelConst.SAFETY_TYPE, String.valueOf(carModel.getSafetyType()));
        cv.put(CarModelConst.POLLUTION_LEVEL, carModel.getPollution_level());
        cv.put(CarModelConst.NUMBER_OF_SEATS, carModel.getNumberOfSeats());
        return cv;
    }
    public static ContentValues ClientToContentValues (Client client)
    {
        ContentValues cv = new ContentValues();
        cv.put(ClientConst.CLIENT_ID, client.getClientID());
        cv.put(ClientConst.CREDIT_CARD, client.getCreditCard());//what is value of?
        cv.put(ClientConst.EMAIL, client.getEmail());
        cv.put(ClientConst.FIRST_NAME, client.getFirstName());
        cv.put(ClientConst.LAST_NAME, client.getLastName());
        cv.put(ClientConst.PASSWORD, client.getPassword());
        cv.put(ClientConst.PHONE_NUMBER, client.getPhoneNumber());
        cv.put(ClientConst.USER_NAME, client.getUserName());
        return cv;
    }
    public static ContentValues OrderToContentValues (Order order)
    {
        ContentValues cv = new ContentValues();
        cv.put(OrderConst.BILL_AMOUNT, String.valueOf(order.getBillAmount()));
        cv.put(OrderConst.CAR_NUMBER, order.getCarNumber());//what is value of?
        cv.put(OrderConst.CLIENT_NUMBER, order.getClientNumber());
        cv.put(OrderConst.END_MILEAGE, order.getEndMileage());
        cv.put(OrderConst.START_MILEAGE, order.getStartMileage());
        cv.put(OrderConst.START_RENT, String.valueOf(order.getStartRent()));
        cv.put(OrderConst.END_RENT, String.valueOf(order.getEndRent()));
        cv.put(OrderConst.FUEL_VOL, order.getFuelVol());
        cv.put(OrderConst.IS_FUEL, order.isFuel());
        cv.put(OrderConst.ORDER_NUMBER, order.getOrderNumber());
        cv.put(OrderConst.ORDER_STATUS, order.isOrderStatus());
        return cv;
    }
    //Methods that get contentValues and return object oriented items
    public static  Address ContentValuesToAddress(ContentValues cv) throws Exception {
        Address address = new Address();
        address.setCity(cv.getAsString(AddressConst.CITY));
        address.setCountry(ENUMS.COUNTRY.valueOf(cv.getAsString(AddressConst.COUNTRY)));
        address.setHouse(cv.getAsInteger(AddressConst.HOUSE));
        address.setDoor(cv.getAsInteger(AddressConst.DOOR));
        return  address;
    }
    public static  Branch ContentValuesToBranch(ContentValues cv) throws Exception {
        Branch branch = new Branch();
        String[] s = (cv.getAsString(BranchConst.BRANCH_ADDRESS).replaceAll("]","")).split(",");
        Address address = new Address(s[2].split("=")[1],ENUMS.COUNTRY.valueOf(s[0].split("=")[1]),Integer.parseInt(s[3].split("=")[1]),Integer.parseInt(s[1].split("=")[1]));
        branch.setBranchAddress(address);//!
        branch.setParkingSpace(cv.getAsInteger(BranchConst.PARKING_SPACE));
        branch.setBranchNumber(cv.getAsLong(BranchConst.BRANCH_NUMBER));
        return  branch;
    }
    public static  Car ContentValuesToCar(ContentValues cv) throws Exception {
        Car car = new Car();
        car.setLicencePlate(cv.getAsString(CarConst.LICENCE_NUMBER));
        car.setLocationNumber(cv.getAsInteger(CarConst.LOCATION_NUMBER));
        car.setMileage(cv.getAsFloat(CarConst.MILEAGE));
        car.setModelType( cv.getAsString(CarConst.MODEL_TYPE));
        car.setFuelMode(ENUMS.FUEL_MODE.valueOf(cv.getAsString(CarConst.FUEL)));
        return  car;
    }
    public static  CarModel ContentValuesToCarModel(ContentValues cv) throws Exception {
        CarModel carModel = new CarModel();
        carModel.setModel(cv.getAsString(CarModelConst.MODEL));
        carModel.setCarCompany(ENUMS.COMPANY.valueOf(cv.getAsString(CarModelConst.CAR_COMPANY)) );
        carModel.setModelName(cv.getAsString(CarModelConst.MODEL_NAME));
        carModel.setEngineVol(cv.getAsInteger(CarModelConst.ENGINE_VOL));
        carModel.setCarColor(ENUMS.COLORS.valueOf(cv.getAsString(CarModelConst.CAR_COLOR)));
        carModel.setGearBox(cv.getAsBoolean(CarModelConst.IS_GEAR));
        carModel.setLimitMileage(cv.getAsBoolean(CarModelConst.IS_LIMIT));
        carModel.setMileageNumber(cv.getAsInteger(CarModelConst.MILEAGE_NUMBER));
        carModel.setNumberOfSeats(cv.getAsShort(CarModelConst.NUMBER_OF_SEATS));
        carModel.setTrunkHeight(cv.getAsFloat(CarModelConst.TRUNK_HEIGHT));
        carModel.setTrunkWidth(cv.getAsFloat(CarModelConst.TRUNK_WIDTH));
        carModel.setAirConditioning(cv.getAsBoolean(CarModelConst.AIR_CONDITIONER));
        carModel.setSafetySystem(cv.getAsBoolean(CarModelConst.IS_SAFETY));
        carModel.setSafetyType(ENUMS.SAFETY.valueOf(cv.getAsString(CarModelConst.SAFETY_TYPE)));
        carModel.setPollution_level(cv.getAsInteger(CarModelConst.POLLUTION_LEVEL));
        return carModel;
    }
    //TODO finish to write the conversion from contentvalues into object
    public static  Client ContentValuesToClient(ContentValues cv) throws Exception {
        Client client = new Client();
        client.setFirstName(cv.getAsString(ClientConst.FIRST_NAME));
        client.setLastName(cv.getAsString(ClientConst.LAST_NAME));
        client.setClientID(cv.getAsString(ClientConst.CLIENT_ID));
        client.setPhoneNumber(cv.getAsLong(ClientConst.PHONE_NUMBER));
        client.setEmail(cv.getAsString(ClientConst.EMAIL));
        client.setCreditCard(cv.getAsInteger(ClientConst.CREDIT_CARD));
        client.setUserName(cv.getAsString(ClientConst.USER_NAME));
        client.setPassword(cv.getAsString(ClientConst.PASSWORD));
        return client;
    }
    public static  Order ContentValuesToOrder(ContentValues cv) throws Exception {
        SimpleDateFormat tmp = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Order order = new Order(cv.getAsInteger(OrderConst.ORDER_NUMBER));
        order.setClientNumber(cv.getAsInteger(OrderConst.CLIENT_NUMBER));
        order.setOrderStatus(cv.getAsBoolean(OrderConst.ORDER_STATUS));
        order.setCarNumber(cv.getAsInteger(OrderConst.CAR_NUMBER));//?
        order.setStartRent(tmp.parse(cv.getAsString(OrderConst.START_RENT)) );
        order.setEndRent(tmp.parse(cv.getAsString(OrderConst.END_RENT)));
        order.setStartMileage(cv.getAsFloat(OrderConst.START_MILEAGE));
        order.setEndMileage(cv.getAsFloat(OrderConst.END_MILEAGE));
        order.setFuel(cv.getAsBoolean(OrderConst.IS_FUEL));
        order.setBillAmount((DecimalFormat) cv.get(OrderConst.BILL_AMOUNT));
        return order;
    }
}
