package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by erevear on 4/14/15.
 */
public class CreateAccountActivity extends Activity {
    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userQuestion;
    private EditText userAnswer;


    private Button saveChanges;

    private String MyPREFERENCES = "myPrefs";
    private String Name = "nameKey";
    private String Email = "emailKey";
    private String Password = "passwordKey";
    private String Question = "securityQuestion";

    SharedPreferences sharedpreferences;
    
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);
        userName = (EditText)findViewById(R.id.username);
        userEmail = (EditText)findViewById(R.id.useremail);
        userPassword = (EditText)findViewById(R.id.userpassword);
        userQuestion = (EditText)findViewById(R.id.usersecurityquestion);
        userAnswer = (EditText)findViewById(R.id.usersecurityanswer);

        saveChanges = (Button)findViewById(R.id.saveuser);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;
            @Override
            public void onClick(View v) {
                newAccount = new Account(userName.getText().toString(),
                        userEmail.getText().toString(), userPassword.getText().toString(), userQuestion.getText().toString(),
                        userAnswer.getText().toString());
                String answer = userQuestion.getText().toString();
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                Editor editor = sharedpreferences.edit();
                editor.putString(Name, newAccount.getUserName());
                editor.putString(Email, newAccount.getUserEmail());
                editor.putString(Password, newAccount.getUserPassword());
                editor.putString(answer, newAccount.getUserAnswer());
                editor.putString(Question, newAccount.getUserQuestion());
                editor.commit();

            }
        });

    }

}
