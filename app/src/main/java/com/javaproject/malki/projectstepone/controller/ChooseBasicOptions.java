package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;

import static com.javaproject.malki.projectstepone.controller.ConstValues.USER_ID_KEY;

/*  2.1 the user choose to add/receive data*/
public class ChooseBasicOptions extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Button searchButton;
    private Spinner addSpinner;
    private void findViews()
    {
        searchButton = (Button) findViewById(R.id.receiveData);
        addSpinner = (Spinner) findViewById(R.id.addOptions);

        searchButton.setOnClickListener(this);
        addSpinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.add_options,
                android.R.layout.select_dialog_multichoice);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice);
        // Apply the adapter to the spinner
        addSpinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            String choice = addSpinner.getSelectedItem().toString();
            switch (choice)
            {
                case "Car":
                    ChooseCar();
                    break;
                case "Model":
                    ChooseModel();
                    break;
                case "User":
                    ChooseUser();
                    break;

        }

    }
    /*
    * GetUser - get the connected client ID
    * return the client's details
    * */
    private String GetUser() throws Exception {
        //get the intent
        Intent myIntent = getIntent();
        //retrieve the extras from the intent - in that intent - the user id
        String usr = myIntent.getStringExtra(ConstValues.USER_ID_KEY);
        //return the user's id
        return usr;
    }
    private void ChooseUser() {
        Intent intent = new Intent(this, AddUser.class);
        //send the user name to the next activity
        try {
            intent.putExtra(USER_ID_KEY, GetUser());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        startActivity(intent);
    }

    private void ChooseModel() {
        Intent intent = new Intent(this, AddModel.class);
        //send the user name to the next activity
        try {
            intent.putExtra(USER_ID_KEY, GetUser());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        startActivity(intent);
    }

    private void ChooseCar() {
        Intent intent = new Intent(this, AddCar.class);
        //send the user name to the next activity
        try {
            intent.putExtra(USER_ID_KEY, GetUser());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(view == searchButton)
        {
            SearchSelection();
        }
    }

    private void SearchSelection() {
        Intent intent = new Intent(this, ReceiveData.class);
        //send the user name to the next activity
        try {
            intent.putExtra(USER_ID_KEY, GetUser());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_basic_options);
        findViews();
    }
}
