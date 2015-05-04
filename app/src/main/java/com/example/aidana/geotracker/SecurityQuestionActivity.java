/*
 * Eva Revear, Aidana Nurlanova, Zheng Young
 */
package com.example.aidana.geotracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aidana.geotracker.controller.ForgotPasswordActivity;
import com.example.aidana.geotracker.model.Account;
import com.example.aidana.geotracker_user.R;

import database.UserDB;

/**
 * Created by erevear on 4/14/15.
 * Edited by anurla
 */
public class SecurityQuestionActivity extends Activity {

    private Button mySubmitButton;
    private TextView mySecurityQuestion;
    private Button back;
    private EditText mySecurityAnswer; private String MyPREFERENCES = "myPrefs";
    private String Question;
    private String Name;

    UserDB userDB;
    private String answer;

    /**
     * Method that creates instances
     * @param savedInstanceState
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security_question);
        Intent intent = getIntent();
        Question = intent.getStringExtra("Question");
        Name = intent.getStringExtra("Name");

        userDB = new UserDB(this);

        mySubmitButton = (Button)findViewById(R.id.submitanswer);
        mySecurityQuestion = (TextView)findViewById(R.id.question);
        mySecurityAnswer = (EditText)findViewById(R.id.answer);
        back = (Button)findViewById(R.id.secquestion_back);
        


        mySecurityQuestion.setText(Question);
        System.out.println(Question);
        mySubmitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String inputAnswer = mySecurityAnswer.getText().toString();
                //String answer = sharedpreferences.getString(Question, "");
                Cursor data = userDB.getData(Name);
                data.moveToFirst();
                String getName = data.getString(data.getColumnIndex(userDB.USER_COLUMN_NAME));
                //question = data.getString(data.getColumnIndex(userDB.USER_COLUMN_SECURITY_Q));
                answer = data.getString(data.getColumnIndex(userDB.USER_COLUMN_SECURITY_A));


                //System.out.println(answer);
                if(inputAnswer.equals(answer)) {
                    Intent i = new Intent(SecurityQuestionActivity.this, NewPasswordActivity.class);
                    startActivity(i);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecurityQuestionActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Alert");
                    builder.setMessage("Incorrect answer \nPlease, try again or register");
                    builder.setInverseBackgroundForced(true);
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.dismiss();
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecurityQuestionActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

    }

}