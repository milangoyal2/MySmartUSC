package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bruins.mysmartusc.EmailFilters;

public class LoginActivity extends AppCompatActivity {

    Button b1;
    EditText ed1,ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();

                    // Create filters class:
                    EmailFilters myFilters = new EmailFilters();

                    // move to next layout:
                    Intent intent = new Intent(LoginActivity.this, ImportantSettingsActivity.class);

                    //Pass filters:
                    intent.putExtra("filters", myFilters);

                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
