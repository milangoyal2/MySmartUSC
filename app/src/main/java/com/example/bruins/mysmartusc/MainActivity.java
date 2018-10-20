package com.example.bruins.mysmartusc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.google.api.services.gmail.Gmail;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent sendMailActivity = new Intent(this, SendMailActivity.class);
        startActivity(sendMailActivity);
//        Intent loginIntent = new Intent(this, LoginActivity.class);
//        startActivity(loginIntent);

    }

    

}
