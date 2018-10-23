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
    EditText imp_emails, imp_keywords, imp_subwords, imp_flagwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_important_settings);

        b1 = (Button)findViewById(R.id.button);
        imp_emails = (EditText)findViewById(R.id.editText);
        imp_keywords = (EditText)findViewById(R.id.editText2);
        imp_subwords = (EditText)findViewById(R.id.editText3);
        imp_flagwords = (EditText)findViewById(R.id.editText4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_emails = imp_emails.getText().toString();
                String string_keywords = imp_keywords.getText().toString();
                String string_subwords = imp_subwords.getText().toString();
                String flagwords = imp_flagwords.getText().toString();
                
                // Parse text and populate filters class:
                Globals g = Globals.getInstance();
                EmailFilters filters = g.getFilters();

                ArrayList<String> emails_list = new ArrayList<String>
                        (Arrays.asList(string_emails.split("\\s*,\\s*")));
                ArrayList<String> subject_list = new ArrayList<String>
                        (Arrays.asList(string_keywords.split("\\s*,\\s*")));
                ArrayList<String> content_list = new ArrayList<String>
                        (Arrays.asList(string_subwords.split("\\s*,\\s*")));
                ArrayList<String> flagwords_list = new ArrayList<String>
                        (Arrays.asList(flagwords.split("\\s*,\\s*")));

                filters.setImpEmails(emails_list);
                filters.setImpKeywords(content_list);
                filters.setImpSubwords(subject_list);
                filters.setFlagwords(flagwords_list);

                //sets global EmailFilters variable
                g.setFilters(filters);

                // move to next layout:
                Toast.makeText(getApplicationContext(),
                        "Redirecting...",Toast.LENGTH_SHORT).show();
                Intent HomepageIntent = new Intent(ImportantSettingsActivity.this, HomePageActivity.class);
                startActivity(HomepageIntent);
            }
        });


    }

}
