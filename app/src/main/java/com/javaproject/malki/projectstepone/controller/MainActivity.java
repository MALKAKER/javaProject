package com.javaproject.malki.projectstepone.controller;

import android.content.ContentValues;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DB_Manager;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.Address;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final String TEST_TAG = "activity test";
    public DB_Manager dbManager;
    public  enum tmp {awe2,b,c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            /*CarModel carmodel = new CarModel("lantis", ENUMS.COMPANY.Mazda,"test", 40, ENUMS.COLORS.Black , true, false, (short) 4,5,5,true,true,14);
            Car car = new Car(1,"lantis",1000,"I5PEQLNP");
            Address address = new Address("BEITAR", ENUMS.COUNTRY.IL,9,5);
            Branch branch = new Branch(address,5,78999);
            ContentValues cv = ConstCars.BranchToContentValues(branch);
            Branch newB = ConstCars.ContentValuesToBranch(cv);
            int g = 0;*/
            //DbManagerFactory dmf = new DbManagerFactory();
            //this.dbManager = dmf.DbType();
            //tmp[] f = tmp.values();
            //int s = f.l
            //android.util.Log.d(TEST_TAG ,);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
