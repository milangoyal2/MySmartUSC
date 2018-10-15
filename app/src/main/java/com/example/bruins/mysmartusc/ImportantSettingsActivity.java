package com.example.bruins.mysmartusc;
import com.example.bruins.mysmartusc.EmailFilters;


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
import java.util.ArrayList;
import java.util.Arrays;



public class ImportantSettingsActivity extends AppCompatActivity {

    Button b1;
    EditText imp_emails, imp_keywords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_important_settings);

        b1 = (Button)findViewById(R.id.button);
        imp_emails = (EditText)findViewById(R.id.editText);
        imp_keywords = (EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_emails = imp_emails.getText().toString();
                String string_keywords = imp_keywords.getText().toString();

                if(!string_emails.isEmpty() &&
                        !string_keywords.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    // Parse text and populate filters class:
                    EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");

                    ArrayList<String> emails_list = new ArrayList<String>
                            (Arrays.asList(string_emails.split("\\s*,\\s*")));
                    ArrayList<String> keywords_list = new ArrayList<String>
                            (Arrays.asList(string_keywords.split("\\s*,\\s*")));

                    filters.setImpEmails(emails_list);
                    filters.setImpKeywords(keywords_list);

                    // move to next layout:
                    Intent unimSettingsIntent = new Intent(ImportantSettingsActivity.this, UnimSettingsActivity.class).putExtra("filters", filters);
                    startActivity(unimSettingsIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Fields can't be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
