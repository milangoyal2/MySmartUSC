package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImportantSettingsActivity extends AppCompatActivity {

    Button b1;
    EditText ed1,ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_important_settings);
        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ed1.getText().toString().isEmpty() &&
                        !ed2.getText().toString().isEmpty() &&
                        !ed3.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    // move to next layout:
                    Intent unimSettingsIntent = new Intent(ImportantSettingsActivity.this, UnimSettingsActivity.class);
                    startActivity(unimSettingsIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Fields can't be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
