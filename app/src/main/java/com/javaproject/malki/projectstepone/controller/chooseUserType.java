package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.Client;

import static com.javaproject.malki.projectstepone.controller.ConstValues.USER_ID_KEY;

/* 1 comes always after login
* the user choose if he is a consumer or
* an employee of car2go*/
public class chooseUserType extends Activity implements View.OnClickListener {
    private Button clientButton;
    private Button employeeButton;
    private void findViews()
    {
        clientButton = (Button) findViewById(R.id.chooseUser);
        employeeButton = (Button) findViewById(R.id.chooseEmployee);
        clientButton.setOnClickListener(this);
        employeeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == clientButton)
        {
            ClientEvent();
        }
        else if (view == employeeButton)
        {
            EmployeeEvent();
        }
    }

    private void EmployeeEvent()  {
        Intent intent = new Intent(this,ChooseBasicOptions.class);
        //send the user name to the next activity
        try {
            intent.putExtra(USER_ID_KEY,GetUser());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        startActivity(intent);
    }

    private void ClientEvent()
    {
        //TODO not now -> the client uses another app in the project
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_type);
        findViews();
    }
}
