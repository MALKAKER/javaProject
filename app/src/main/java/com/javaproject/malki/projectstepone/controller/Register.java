package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
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

public class Register extends Activity implements View.OnClickListener{
    private EditText fName;
    private EditText lName;
    private EditText id;
    private EditText phone;
    private EditText mail;
    private EditText cc;
    private EditText password;
    private EditText confirmPass;
    private RadioButton isAgree;
    private Button registerUser;

    private void findViews()
    {
        fName = (EditText) findViewById(R.id.enterFirstName);
        lName = (EditText) findViewById(R.id.enterLastName);
        id = (EditText) findViewById(R.id.enterID);
        phone = (EditText) findViewById(R.id.enterPhone);
        mail = (EditText) findViewById(R.id.enterMail);
        cc = (EditText) findViewById(R.id.enterCredit);
        password = (EditText) findViewById(R.id.enterPassword);
        confirmPass = (EditText) findViewById(R.id.confirmPassword);
        isAgree = (RadioButton) findViewById(R.id.isAgree);
        registerUser = (Button) findViewById(R.id.registerButton);

        registerUser.setOnClickListener(this);
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
            String userConfirm = this.confirmPass.getText().toString();
            checkFill(userConfirm);
            Boolean userAgree = this.isAgree.isChecked();
            if(userPassword.equals(userConfirm) && userAgree)
            {
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
            else
            {
                password.setText("");
                confirmPass.setText("");
                throw new Exception(getString(R.string.Incorrect_password_Error));
            }
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

    private void registerUserActivity()
    {
        String user = addUserFunc();
        if(user != null)
        {
            Intent intent = new Intent(this,chooseUserType.class);
            //send the user name to the next activity
            intent.putExtra(ConstValues.USER_ID_KEY,user);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Toast.makeText(getApplicationContext(),R.string.welcome,Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View view) {
        if(view == registerUser)
        {
            registerUserActivity();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
    }
}
