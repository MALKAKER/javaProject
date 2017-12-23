package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;

import java.util.ArrayList;
import java.util.List;

public class AddModel extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    private Spinner compSpin;
    private EditText modelSpin;
    private EditText modelTypeSpin;
    private Spinner colorSpin;
    private EditText editEngeenVolume;
    private Switch switchGear;
    private Switch switchLimitMileage;
    private EditText editMileage;
    private EditText editTrunkW;
    private EditText editTrunkH;
    private EditText editSeats;
    private RadioButton radioIsAir;
    private Switch switchSafety;
    private Spinner spinnerSafety;
    private SeekBar seekBarPollution;
    private Button addModelButton;


    //initiate the views
    private void findViews()
    {
        this.compSpin = (Spinner) findViewById(R.id.addModel_enterCompany);
        this.modelSpin = (EditText) findViewById(R.id.addModel_enterModel);
        this.modelTypeSpin = (EditText) findViewById(R.id.addModel_enterModelType);
        this.colorSpin = (Spinner) findViewById(R.id.addModel_enterColor);
        this.editEngeenVolume = (EditText) findViewById(R.id.addModel_enterVolume);
        this.switchGear = (Switch) findViewById(R.id.addModel_isGear);
        this.switchLimitMileage = (Switch) findViewById(R.id.addModel_isMileage);
        this.editMileage = (EditText) findViewById(R.id.addModel_enterMileage);
        this.editTrunkW = (EditText) findViewById(R.id.addModel_enterTrunkWidth);
        this.editTrunkH = (EditText) findViewById(R.id.addModel_enterTrunkHeight);
        this.editSeats = (EditText) findViewById(R.id.addModel_enterSeats);
        this.radioIsAir = (RadioButton) findViewById(R.id.addModel_isAir);
        this.switchSafety = (Switch) findViewById(R.id.addModel_isSafety);
        this.spinnerSafety = (Spinner) findViewById(R.id.addModel_systemType);
        this.seekBarPollution = (SeekBar) findViewById(R.id.addModel_pollutionLevel);
        this.addModelButton = (Button) findViewById(R.id.addModel_addModel);

        //spinners initiations
        compSpin.setAdapter(new ArrayAdapter<ENUMS.COMPANY>(this, android.R.layout.simple_list_item_1, ENUMS.COMPANY.values()));
        colorSpin.setAdapter(new ArrayAdapter<ENUMS.COLORS>(this, android.R.layout.simple_list_item_1, ENUMS.COLORS.values()));
        spinnerSafety.setEnabled(false);
        spinnerSafety.setAdapter(new ArrayAdapter<ENUMS.SAFETY>(this, android.R.layout.simple_list_item_1, ENUMS.SAFETY.values()));
        switchGear.setOnCheckedChangeListener(this);
        switchLimitMileage.setOnCheckedChangeListener(this);
        switchSafety.setOnCheckedChangeListener(this);
        //SeekBar initiation
        seekBarPollution.setOnSeekBarChangeListener(this);
        //button initiation
        addModelButton.setOnClickListener(this);
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Toast.makeText(getApplicationContext(), getString(R.string.Pollution_Level) + " " + i, Toast.LENGTH_SHORT).show();
        //Toast warning when the model's pollution level is too high
        if (i > 11)
            Toast.makeText(getApplicationContext(), R.string.WARNING_This_model_harms_the_environment, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        switch (compoundButton.getId())
        {
            case R.id.addModel_isGear:
                //do nothing - no hidden edit-text
                break;
            case R.id.addModel_isMileage:
                //if there is a limit on mileage edit the number of mil.
                if (isChecked)
                    editMileage.setEnabled(true) ;
                else{
                    editMileage.setText("");
                    editMileage.setEnabled(false);}
                break;
            case R.id.addModel_isSafety:
                //if there is a safety system enable to choose the type
                if (isChecked)
                    spinnerSafety.setEnabled(true);
                else
                    spinnerSafety.setEnabled(false);
                break;
        }

    }

    @Override
    public void onClick(View view) {
        if(view == addModelButton)
        {
            AddModelFunction();
        }
    }

    /*
    * AddModelFunction() - sets the new model and add it to the DB
    * */

    private void AddModelFunction() {
        final ContentValues contentValues = new ContentValues();
        try {
            String comp = compSpin.getSelectedItem().toString();
            checkFill(comp);
            String mod = modelSpin.getText().toString();
            checkFill(mod);
            String modT = modelTypeSpin.getText().toString();
            checkFill(modT);
            String color = colorSpin.getSelectedItem().toString();
            checkFill(color);
            String safeTyp = spinnerSafety.getSelectedItem().toString();
            checkFill(editEngeenVolume.getText().toString());
            int engVol = Integer.valueOf(editEngeenVolume.getText().toString());
            checkFill(editTrunkW.getText().toString());
            float trunkW = Float.valueOf(editTrunkW.getText().toString());
            checkFill(editTrunkW.getText().toString());
            float trunkH = Float.valueOf(editTrunkH.getText().toString());
            checkFill(editSeats.getText().toString());
            int seatNum = Integer.valueOf(editSeats.getText().toString());
            //miNum is not converted to int because the field can be empty
            int miNum = editMileage.getText().toString().equals("")? 1 : Integer.valueOf(editMileage.getText().toString());
            //the switches and the radio button can be unchecked -also a value to the field
            Boolean gear = switchGear.isChecked();
            Boolean isMil = switchLimitMileage.isChecked();
            Boolean isSafe = switchSafety.isChecked();
            Boolean isAir = radioIsAir.isChecked();
            int level = seekBarPollution.getProgress();

            contentValues.put(ConstCars.CarModelConst.SAFETY_TYPE, safeTyp);
            contentValues.put(ConstCars.CarModelConst.MODEL, mod);
            contentValues.put(ConstCars.CarModelConst.MODEL_NAME, modT);
            contentValues.put(ConstCars.CarModelConst.ENGINE_VOL, engVol);
            contentValues.put(ConstCars.CarModelConst.IS_SAFETY, isSafe);
            contentValues.put(ConstCars.CarModelConst.IS_GEAR, gear);
            contentValues.put(ConstCars.CarModelConst.IS_LIMIT, isMil);
            contentValues.put(ConstCars.CarModelConst.CAR_COMPANY, comp);
            contentValues.put(ConstCars.CarModelConst.CAR_COLOR, color);
            contentValues.put(ConstCars.CarModelConst.AIR_CONDITIONER, isAir);
            contentValues.put(ConstCars.CarModelConst.TRUNK_WIDTH, trunkW);
            contentValues.put(ConstCars.CarModelConst.TRUNK_HEIGHT, trunkH);
            contentValues.put(ConstCars.CarModelConst.POLLUTION_LEVEL, level);
            contentValues.put(ConstCars.CarModelConst.MILEAGE_NUMBER, miNum);
            contentValues.put(ConstCars.CarModelConst.NUMBER_OF_SEATS, seatNum);
            //todo asynctask
            if (isMil && miNum == 1)
                throw new Exception(getString(R.string.Missing_field_Error));
            DbManagerFactory.getManager().AddModel(contentValues);
            //Toast if the action succeed
            Toast.makeText(getApplicationContext(), R.string.The_model_successfully_added , Toast.LENGTH_LONG).show();

        }catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }

    }

    //Check if the field was filled
    private void checkFill(String str) throws Exception {
        if(str.equals(""))
        {
            throw new Exception(getString(R.string.Missing_field_Error));
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = radioIsAir.isChecked();
        if (checked)
            Toast.makeText(getApplicationContext() , getString(R.string.Air_Conditioning) , Toast.LENGTH_LONG).show();
        // Check which radio button was clicked

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        findViews();
    }


}
