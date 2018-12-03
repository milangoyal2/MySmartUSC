package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ChangeNotificationsActivity extends AppCompatActivity {

    protected void initSpinners() {
        Spinner spinnerSender = (Spinner)findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sender_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerSender.setAdapter(adapter);

        // spinner 2 (subject)
        Spinner spinnerSubject = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.subject_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapter2);

        // spinner 3 (subject)
        Spinner spinnerContent = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.content_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerContent.setAdapter(adapter3);

        // spinner 4 (subject)
        Spinner spinnerFlag = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.flag_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFlag.setAdapter(adapter4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_notifications_settings_layout);

        Button backToSettings = (Button)findViewById(R.id.backToSettings);


        //Initialize all the spinners
        initSpinners();

        backToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent changeSpecSettingsIntent = new Intent(ChangeNotificationsActivity.this, ChangeSettingsActivity.class);
                startActivity(changeSpecSettingsIntent);
            }
        });
    }
}
