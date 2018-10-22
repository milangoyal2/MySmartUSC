 package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class ChangeSettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_settings_layout);


        Button unimportantEmailsButton = (Button)findViewById(R.id.changeUnimEmailsButton);
        Button unimportantKeywordsButton = (Button)findViewById(R.id.changeUnimKeywordsButton);
        Button importantEmailsButton = (Button)findViewById(R.id.changeImpEmailsButton);
        Button importantKeywordsButton = (Button)findViewById(R.id.changeImpKeywordsButton);

        unimportantEmailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, SpecChangeSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        unimportantKeywordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, SpecChangeSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        importantEmailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, SpecChangeSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        importantKeywordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, SpecChangeSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });


    }
}