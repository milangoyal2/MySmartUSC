package com.example.bruins.mysmartusc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    if not logged in, take to LogInActivity
    (loginActivity sets a user token)
    */
    if (Util.getToken() != null) {
        Intent loginIntent = Intent(this, LoginActivity::; class.java);
        startActivity(loginIntent);
    }



    finish();
}
