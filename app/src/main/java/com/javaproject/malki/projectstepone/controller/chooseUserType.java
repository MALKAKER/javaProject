package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.os.Bundle;

import com.javaproject.malki.projectstepone.R;
/* 1 comes always after login
* the user choose if he is a consumer or
* an employee of car2go*/
public class chooseUserType extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_type);
    }
}
