package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by erevear on 4/16/15.
 */
public class MyProfileActivity extends Activity {
    private TextView name;
    private TextView email;
    private TextView password;
    private TextView question;
    private TextView answer;
    private Button back;

    SharedPreferences sharedpreferences;
    private String MyPREFERENCES = "myPrefs";
    private String Name = "nameKey";
    private String Email = "emailKey";
    private String Password = "passwordKey";
    private String Question = "securityQuestion";

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        name = (TextView)findViewById(R.id.profile_name);
        email = (TextView)findViewById(R.id.profile_email);
        password = (TextView)findViewById(R.id.profile_password);
        question = (TextView)findViewById(R.id.profile_question);
        answer = (TextView)findViewById(R.id.profile_answer);
        back = (Button)findViewById(R.id.profile_back);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        String profileName = sharedpreferences.getString(Name, "");
        String profileEmail = sharedpreferences.getString(Email, "");
        String profilePassword = sharedpreferences.getString(Password, "");
        String profileQuestion = sharedpreferences.getString(Question, "");
        String profileAnswer = sharedpreferences.getString(sharedpreferences.getString(Question, ""), "");

        name.setText(profileName);
        email.setText(profileEmail);
        password.setText(profilePassword);
        question.setText(profileQuestion);
        answer.setText(profileAnswer);


        back.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyProfileActivity.this, AccountActivity.class);
                startActivity(i);
            }
        });






    }

}
