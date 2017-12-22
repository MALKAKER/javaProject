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

import static com.javaproject.malki.projectstepone.controller.ConstValues.USER_ID_KEY;

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
    
    private void initiation() throws Exception {
        ContentValues address1 = new ContentValues();
        address1.put(ConstCars.AddressConst.CITY, "Beitar");
        address1.put(ConstCars.AddressConst.COUNTRY, ENUMS.COUNTRY.IL.toString());
        address1.put(ConstCars.AddressConst.HOUSE, 4);


        ContentValues client1 = new ContentValues();
        client1.put(ConstCars.ClientConst.CLIENT_ID, "316301191");
        client1.put(ConstCars.ClientConst.EMAIL, "A@gmail.com");
        client1.put(ConstCars.ClientConst.CREDIT_CARD, "1223456789");
        client1.put(ConstCars.ClientConst.FIRST_NAME, "A");
        client1.put(ConstCars.ClientConst.LAST_NAME, "AA");
        client1.put(ConstCars.ClientConst.PASSWORD, "malki1996");
        client1.put(ConstCars.ClientConst.PHONE_NUMBER, "0545337060");
        client1.put(ConstCars.ClientConst.USER_NAME, "");
        DbManagerFactory.getManager().AddClient(client1);
        ContentValues model1 = new ContentValues();
        model1.put(ConstCars.CarModelConst.MODEL_NAME, "lantis");
        model1.put(ConstCars.CarModelConst.MODEL, "ERF123");
        model1.put(ConstCars.CarModelConst.AIR_CONDITIONER, Boolean.TRUE);
        model1.put(ConstCars.CarModelConst.CAR_COLOR, ENUMS.COLORS.Black.toString());
        model1.put(ConstCars.CarModelConst.CAR_COMPANY, ENUMS.COMPANY.Mazda.toString());
        model1.put(ConstCars.CarModelConst.ENGINE_VOL, "4");
        model1.put(ConstCars.CarModelConst.IS_GEAR, Boolean.TRUE);
        model1.put(ConstCars.CarModelConst.IS_LIMIT, Boolean.TRUE);
        model1.put(ConstCars.CarModelConst.IS_SAFETY, Boolean.TRUE);
        model1.put(ConstCars.CarModelConst.MILEAGE_NUMBER, 40000);
        model1.put(ConstCars.CarModelConst.NUMBER_OF_SEATS, 5);
        model1.put(ConstCars.CarModelConst.POLLUTION_LEVEL, 8);
        model1.put(ConstCars.CarModelConst.TRUNK_HEIGHT ,0.4);
        model1.put(ConstCars.CarModelConst.TRUNK_WIDTH, 1);
        model1.put(ConstCars.CarModelConst.SAFETY_TYPE, ENUMS.SAFETY.Mobileye.toString());
        DbManagerFactory.getManager().AddModel(model1);
        ContentValues branch1 = new ContentValues();
        branch1.put(ConstCars.BranchConst.BRANCH_NUMBER, 12345678);
        branch1.put(ConstCars.BranchConst.BRANCH_ADDRESS, String.valueOf(address1.valueSet()));
        branch1.put(ConstCars.BranchConst.PARKING_SPACE, 5);
        DbManagerFactory.getManager().AddBranch(branch1);
        ContentValues car1 = new ContentValues();
        car1.put(ConstCars.CarConst.LICENCE_NUMBER, "12345678");
        car1.put(ConstCars.CarConst.FUEL, ENUMS.FUEL_MODE.Full.toString());
        car1.put(ConstCars.CarConst.LOCATION_NUMBER, "12345678");
        car1.put(ConstCars.CarConst.MODEL_TYPE, "ERF123");
        car1.put(ConstCars.CarConst.MILEAGE, "12345678");
        DbManagerFactory.getManager().AddCar(car1);
        ContentValues car2 = new ContentValues();
        car2.put(ConstCars.CarConst.LICENCE_NUMBER, "87654321");
        car2.put(ConstCars.CarConst.FUEL, ENUMS.FUEL_MODE.Full.toString());
        car2.put(ConstCars.CarConst.LOCATION_NUMBER, "12345678");
        car2.put(ConstCars.CarConst.MODEL_TYPE, "ERF123");
        car2.put(ConstCars.CarConst.MILEAGE, "100000");
        DbManagerFactory.getManager().AddCar(car2);

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
                intent.putExtra(USER_ID_KEY,user);
                Toast.makeText(getApplicationContext(),getString(R.string.welcome) +" " +
                        DbManagerFactory.getManager().GetClient(user).getFirstName(),Toast.LENGTH_SHORT).show();
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
        try {
            initiation();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

//DbManagerFactory dmf = new DbManagerFactory();
//this.dbManager = dmf.DbType();
//tmp[] f = tmp.values();
//int s = f.l
//android.util.Log.d(TEST_TAG ,);