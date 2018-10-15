package com.example.bruins.mysmartusc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UnimSettingsActivity extends AppCompatActivity {

    Button nextButton;
    EditText emails, keywords;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unim_settings);

        header = (TextView)findViewById(R.id.textView);
        nextButton = (Button)findViewById(R.id.nextButton);
        emails = (EditText)findViewById(R.id.emails);
        keywords = (EditText)findViewById(R.id.keywords);

        String myHeader = "Enter keywords and emails for which you don't want notifications";
        header.setText(myHeader);
    }
}
