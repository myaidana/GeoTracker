package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by erevear on 4/14/15.
 */
public class GeoActivity extends Activity {
    private EditText myName;
    private EditText myPassword;

    private Button myLogin;
    private Button myCreateAccount;
    private Button myForgotPassword;

    private String MyPREFERENCES = "myPrefs";

    SharedPreferences sharedpreferences;

    private String Name = "nameKey";
    private String Password = "passwordKey";


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        myName = (EditText)findViewById(R.id.name);
        myPassword = (EditText)findViewById(R.id.password);

        myLogin = (Button)findViewById(R.id.loginbutton);
        myCreateAccount = (Button)findViewById(R.id.createaccountbutton);
        myForgotPassword = (Button)findViewById(R.id.forgotpasswordbutton);


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        myCreateAccount.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i= new Intent(GeoActivity.this, CreateAccountActivity.class);
                startActivity(i);

            }
        });

        myLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String username = sharedpreferences.getString(Name, "");
                String password = sharedpreferences.getString(Password, "");
                System.out.println(password);
                System.out.println(username);
                if(myName.getText().toString().equals(username) && myPassword.getText().toString().equals(password)) {
                    Intent i = new Intent(GeoActivity.this, AccountActivity.class);
                    startActivity(i);
                }


            }
        });

        myForgotPassword.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                    Intent i = new Intent(GeoActivity.this, SecurityQuestionActivity.class);
                    startActivity(i);



            }
        });

    }

}
