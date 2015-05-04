/*
 * Eva Revear, Aidana Nurlanova, Zheng Young
 */
package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aidana.geotracker.controller.GeoActivity;
import com.example.aidana.geotracker.model.Account;
import com.example.aidana.geotracker_user.R;

import database.UserDB;

/**
 * Created by erevear on 4/14/15.
 * Edited by anurla92
 */
public class NewPasswordActivity extends Activity {


    private Button setPassword;
    private EditText enterPassword;
    private EditText enteruserName;
    private Button back;


    private String Name = "nameKey";
    private String Email = "emailKey";
    private String Password = "passwordKey";
    private String Question = "securityQuestion";



    UserDB userDB;

    /**
     * Method that creates instances
     * @param savedInstanceState
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);


        back=(Button)findViewById(R.id.resetpass_back);
        setPassword = (Button)findViewById(R.id.savenewpassword);
        enterPassword = (EditText)findViewById(R.id.change_password);
        enteruserName = (EditText)findViewById(R.id.changepass_username);

        userDB = new UserDB(this);

        setPassword.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {

                String username = enteruserName.getText().toString();
                String password = enterPassword.getText().toString();


                //System.out.println(username);

                if(username.length() > 0 && password.length() > 0) {
                    userDB.updateContact(username, password);

                    Intent i = new Intent(NewPasswordActivity.this, GeoActivity.class);
                    startActivity(i);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Please fill in all fields";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewPasswordActivity.this, SecurityQuestionActivity.class);
                startActivity(i);
            }
        });


    }

}