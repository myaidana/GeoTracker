package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences.Editor;

/**
 * Created by erevear on 4/14/15.
 */
public class NewPasswordActivity extends Activity {


    private Button setPassword;
    private EditText enterPassword;


    private String MyPREFERENCES = "myPrefs";
    private String Name = "nameKey";
    private String Email = "emailKey";
    private String Password = "passwordKey";
    private String Question = "securityQuestion";

    SharedPreferences sharedpreferences;



    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        setPassword = (Button)findViewById(R.id.savenewpassword);
        enterPassword = (EditText)findViewById(R.id.newpassword);


        setPassword.setOnClickListener(new View.OnClickListener() {
            Editor editor = sharedpreferences.edit();

            @Override
            public void onClick(View v) {

                editor.putString(Password, enterPassword.getText().toString());
                editor.commit();

            }
        });



    }

}
