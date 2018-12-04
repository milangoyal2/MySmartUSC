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

        Button favFlagButton = (Button)findViewById(R.id.changeFavFlagButton);
        Button importantSubwordsButton = (Button)findViewById(R.id.changeImpSubwordsButton);
        Button importantEmailsButton = (Button)findViewById(R.id.changeImpEmailsButton);
        Button importantKeywordsButton = (Button)findViewById(R.id.changeImpKeywordsButton);
        Button changeNotificationsButton = (Button)findViewById(R.id.changeNotificationsButton);
        Button goHomeButton = (Button)findViewById(R.id.settingsHomeButton);

        favFlagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, ChangeFavFlagSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        importantSubwordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, ChangeImpSubwordsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        importantEmailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, ChangeImpEmailsSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        importantKeywordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, ChangeImpKeywordsSettingsActivity.class).putExtra("filters", filters);
                startActivity(changeSpecSettingsIntent);
            }
        });

        changeNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent changeSpecSettingsIntent = new Intent(ChangeSettingsActivity.this, ChangeNotificationsActivity.class);
                startActivity(changeSpecSettingsIntent);
            }
        });

        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeIntent = new Intent(ChangeSettingsActivity.this, HomePageActivity.class);
                startActivity(homeIntent);
            }
        });



    }
}