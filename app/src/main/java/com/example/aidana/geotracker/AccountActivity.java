package com.example.aidana.geotracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by erevear on 4/14/15.
 */
public class AccountActivity extends Activity {
    private Button Logout;
    private Button myProfile;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity);

        Logout = (Button)findViewById(R.id.logout);
        myProfile = (Button)findViewById(R.id.myprofile);

        Logout.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountActivity.this, GeoActivity.class);
                startActivity(i);
            }
        });

        myProfile.setOnClickListener(new View.OnClickListener() {
            private Account newAccount;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountActivity.this,MyProfileActivity.class);
                startActivity(i);
            }
        });



    }

}
