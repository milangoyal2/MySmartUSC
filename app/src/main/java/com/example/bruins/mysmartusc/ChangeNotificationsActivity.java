package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ChangeNotificationsActivity extends AppCompatActivity {

//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//        String notifPriority = parent.getItemAtPosition(pos).toString();
//
//        if (notifPriority)
//
//    }
//
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_notifications_settings_layout);

        Button backToSettings = (Button)findViewById(R.id.backToSettings);
        Button submitButton = (Button)findViewById(R.id.submit);

        //Initialize all the spinners
        final Spinner spinnerKeyword = (Spinner)findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sender_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerKeyword.setAdapter(adapter);

        // spinner 2 (flag)
        final Spinner spinnerFlag = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.flag_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFlag.setAdapter(adapter2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keywordPriority = spinnerKeyword.getSelectedItem().toString();
                if (keywordPriority.equals("HIGH")) {
                    Globals.getInstance().keywordsNotification = 1;
                } else {
                    Globals.getInstance().keywordsNotification = 0;
                }

                String flagPriority = spinnerFlag.getSelectedItem().toString();
                if (flagPriority.equals("HIGH")) {
                    Globals.getInstance().flagNotification = 1;
                } else {
                    Globals.getInstance().flagNotification = 0;
                }

                Toast.makeText(getApplicationContext(),
                        "Preferences submitted", Toast.LENGTH_SHORT).show();
            }
        });

        backToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeSpecSettingsIntent = new Intent(ChangeNotificationsActivity.this, ChangeSettingsActivity.class);
                startActivity(changeSpecSettingsIntent);
            }
        });
    }
}
