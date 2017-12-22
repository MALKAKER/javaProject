package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;

import java.util.ArrayList;
import java.util.List;

public class AddCar extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Spinner locNum;
    private Spinner modelNum;
    private EditText license;
    private EditText mileageNum;
    private SeekBar fuel;
    private Button addCar;

    private void findViews()
    {
        locNum = (Spinner) findViewById(R.id.locationNumber);
        modelNum = (Spinner) findViewById(R.id.getModel);
        license = (EditText) findViewById(R.id.GetLicenceNumber);
        mileageNum = (EditText) findViewById(R.id.MileageCounter);
        fuel = (SeekBar) findViewById(R.id.fuelAmount);
        addCar = (Button) findViewById(R.id.addCar);

        addCar.setOnClickListener(this);
        //TODO this should be in asynctask
        locNum.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getLocations()));
        modelNum.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getModels()));
        fuel.setOnSeekBarChangeListener(this);

    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //get strings from current DB to spinner
    private String[] getLocations()
    {
        String s[] = new String[]{};
        List<String> lst = new ArrayList<String>();
        for (Branch b : DbManagerFactory.getManager().GetBranches())
        {
               lst.add(String.format("%d", b.getBranchNumber()));
        }
        return lst.toArray(s);
    }

    private String[] getModels()
    {
        String s[] = new String[]{};
        List<String> lst = new ArrayList<String>();
        for (CarModel cm : DbManagerFactory.getManager().GetModels())
        {
            lst.add(cm.getModel());
        }
        return lst.toArray(s);
    }
    public AddCar() {
        super();
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//seekBar implementation
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        Toast.makeText(getApplicationContext(),progress +"% fuel", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    @Override
    public void onClick(View view) {
        if(view == addCar)
        {
            String message = AddCarFunc();
            Toast.makeText(getApplicationContext(), R.string.The_car_successfully_added, Toast.LENGTH_LONG);
        }

    }

    private String AddCarFunc() {
        String str = null;
        try
        {
            final ContentValues contentValues = new ContentValues();

            String location = locNum.getSelectedItem().toString();
            checkFill(location);
            String modelT = modelNum.getSelectedItem().toString();
            checkFill(modelT);
            String licenceNum = license.getText().toString();
            checkFill(licenceNum);
            int mil = Integer.valueOf(mileageNum.getText().toString());
            int f = fuel.getProgress();
            ENUMS.FUEL_MODE fmode = ENUMS.FUEL_MODE.Low;
            if(f < 25){fmode = ENUMS.FUEL_MODE.Empty;}
            else if(f >= 25 && f < 50){fmode = ENUMS.FUEL_MODE.Low;}
            else if(f >= 50 && f < 75){fmode = ENUMS.FUEL_MODE.Medium;}
            else if(f >= 75 && f <= 100){fmode = ENUMS.FUEL_MODE.Full;}
            if(mil != 0 && f !=0)
            {
                contentValues.put(ConstCars.CarConst.MILEAGE, mil );
                contentValues.put(ConstCars.CarConst.MODEL_TYPE, modelT);
                contentValues.put(ConstCars.CarConst.LOCATION_NUMBER, licenceNum);
                contentValues.put(ConstCars.CarConst.FUEL, fmode.toString());
                contentValues.put(ConstCars.CarConst.LICENCE_NUMBER, licenceNum);

                str = DbManagerFactory.getManager().AddCar(contentValues);

            }
            else
            {
                throw new Exception("Mileage or fuel cannot be zero");
            }
        }catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
        return str;
    }

    //Check if the field was filled
    private void checkFill(String str) throws Exception {
        if(str.equals(""))
        {
            throw new Exception(getString(R.string.Missing_field_Error));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }
}
