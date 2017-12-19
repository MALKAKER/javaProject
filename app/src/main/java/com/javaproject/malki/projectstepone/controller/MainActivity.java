package com.javaproject.malki.projectstepone.controller;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DB_Manager;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.Address;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.ENUMS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button register;
    private Button signIn;
    private EditText userName;
    private EditText password;
    private void findViews()
    {
        register = (Button) findViewById(R.id.register);
        signIn = (Button) findViewById(R.id.signIn);
        userName = (EditText)findViewById(R.id.enterUser);
        password = (EditText)findViewById(R.id.enterPassword);
        register.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    /*
    * CheckPassword - Checks if the password is correct
    * returns true if the user name and the password are correct
    * */
    private Boolean CheckPassword(String name, String password1) throws Exception {

            //get the user from the DB according to user name
            Client c =DbManagerFactory.getManager().GetClient(name);
            //If the input password is not correct
            if(!c.getPassword().equals(password1)|| c == null)
                throw new Exception("Incorrect password or user-name");

        return true;
    }
    private void RegisterActivity()
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
    private void SignInActivity()
    {
        try
        {
            //Toast.makeText(this, "blah", Toast.LENGTH_SHORT).show();
            String user = this.userName.getText().toString();
            this.password.getText();
            String pass = this.password.getText().toString();
            //checks if the edittext is full
            if (!CheckNoInput(user, pass))
            {

            }
            //check if the password is correct
            else if (CheckPassword(user, pass)){
                Intent intent = new Intent(this,chooseUserType.class);
                //send the user name to the next activity
                intent.putExtra(getString(R.string.extra_user),user);
                Toast.makeText(getApplicationContext(),R.string.welcome,Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        }
        catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }

    }

    private Boolean CheckNoInput(String user, String pass) {
        if(user.trim().equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(),R.string.Enter_user_name, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return false;
        }
        else if (pass.equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(),R.string.Enter_password_error, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return  false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    @Override
    public void onClick(View view) {
        if(view == register)
        {
            RegisterActivity();
        }
        else if (view == signIn)
        {
            SignInActivity();
        }

    }
}
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