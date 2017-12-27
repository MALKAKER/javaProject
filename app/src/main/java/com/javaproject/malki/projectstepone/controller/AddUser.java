package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.backend.ConstCars;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;

public class AddUser extends Activity implements View.OnClickListener{
    private EditText fName;
    private EditText lName;
    private EditText id;
    private EditText phone;
    private EditText mail;
    private EditText cc;
    private EditText password;
    private Button addUser;

    private void findViews()
    {
        fName = (EditText) findViewById(R.id.addUser_enterFirstName);
        lName = (EditText) findViewById(R.id.addUser_enterLastName);
        id = (EditText) findViewById(R.id.addUser_enterID);
        phone = (EditText) findViewById(R.id.addUser_enterPhone);
        mail = (EditText) findViewById(R.id.addUser_enterMail);
        cc = (EditText) findViewById(R.id.addUser_enterCredit);
        password = (EditText) findViewById(R.id.addUser_enterPassword);

        addUser = (Button) findViewById(R.id.addUser_addButton);

        addUser.setOnClickListener(this);
    }

    private String addUserFunc()
    {
        final ContentValues contentValues = new ContentValues();
        String str = null;
        try {
            String userFirst = this.fName.getText().toString();
            checkFill(userFirst);
            String userLast = this.lName.getText().toString();
            checkFill(userLast);
            String userId = this.id.getText().toString();
            checkFill(userId);
            String userPhone = this.phone.getText().toString();
            checkFill(userPhone);
            String userMail = this.mail.getText().toString();
            checkFill(userMail);
            String userCc = this.cc.getText().toString();
            checkFill(userCc);
            String userPassword = this.password.getText().toString();
            checkFill(userPassword);

            contentValues.put(ConstCars.ClientConst.CLIENT_ID, userId);
            contentValues.put(ConstCars.ClientConst.EMAIL, userMail);
            contentValues.put(ConstCars.ClientConst.CREDIT_CARD, userCc);
            contentValues.put(ConstCars.ClientConst.FIRST_NAME, userFirst);
            contentValues.put(ConstCars.ClientConst.LAST_NAME, userLast);
            contentValues.put(ConstCars.ClientConst.PASSWORD, userPassword);
            contentValues.put(ConstCars.ClientConst.PHONE_NUMBER, userPhone);
            contentValues.put(ConstCars.ClientConst.USER_NAME, "");
            new AsyncTask<Void, Void, String>()
            {
                @Override
                protected void onPostExecute(String idResult)
                {
                    super.onPostExecute(idResult);
                    if (idResult != null)
                        Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                }
                @Override
                protected String doInBackground(Void... params)
                {
                    try {
                        return DbManagerFactory.getManager().AddClient(contentValues);
                    } catch (Exception e) {
                        return  null;
                    }
                } }.execute();
            //str = DbManagerFactory.getManager().AddClient(contentValues);
            Toast.makeText(getApplicationContext(),R.string.welcome, Toast.LENGTH_SHORT);    
            
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
        return str;
    }

    private void checkFill(String str) throws Exception {
        if(str.equals(""))
        {
            throw new Exception(getString(R.string.Missing_field_Error));
        }
    }

    private void addUserActivity()
    {
        String user = addUserFunc();

    }
    @Override
    public void onClick(View view) {
        if(view == addUser)
        {
            addUserActivity();
        }
    }

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        findViews();
    }
}
