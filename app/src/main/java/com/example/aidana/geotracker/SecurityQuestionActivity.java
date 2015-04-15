package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by erevear on 4/14/15.
 */
public class SecurityQuestionActivity extends Activity {

    private Button mySubmitButton;
    private TextView mySecurityQuestion;
    private EditText mySecurityAnswer;


    private String MyPREFERENCES = "myPrefs";
    private String Name = "nameKey";
    private String Email = "emailKey";
    private String Password = "passwordKey";
    private String Question = "securityQuestion";

    SharedPreferences sharedpreferences;


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security_question);

        mySubmitButton = (Button)findViewById(R.id.submitanswer);
        mySecurityQuestion = (TextView)findViewById(R.id.question);
        mySecurityAnswer = (EditText)findViewById(R.id.answer);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        mySecurityQuestion.setText(sharedpreferences.getString(Question, ""));
        mySubmitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String inputAnswer = mySecurityAnswer.getText().toString();
                String answer = sharedpreferences.getString(sharedpreferences.getString(Question, ""), "");
                System.out.println(answer);
                if(inputAnswer.equals(answer)) {
                    Intent i = new Intent(SecurityQuestionActivity.this, NewPasswordActivity.class);
                    startActivity(i);
                }

            }
        });




    }

}
