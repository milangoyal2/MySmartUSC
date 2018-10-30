package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ChangeImpKeywordsSettingsActivity extends AppCompatActivity {

    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    //returns the current important keywords
    protected String getCurrent(){
        String imp_keywords_str = "";
        for (int i = 0; i < filters.getImpKeywords().size(); i++) {

            if (i == filters.getImpKeywords().size() - 1) {
                imp_keywords_str += filters.getImpKeywords().get(i);
            } else {
                imp_keywords_str += filters.getImpKeywords().get(i) + ", ";
            }
        }
        return imp_keywords_str;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_impkeywords_settings_layout);

        TextView imp_keywords = findViewById(R.id.textView16);

        //displays the current important keywords
        imp_keywords.setText(getCurrent());

        //for parsing the newly entered important keywords
        Button changeImpkeywordsSetButton = (Button)findViewById(R.id.impKeywordsSetButton);
        System.out.println(changeImpkeywordsSetButton);
        changeImpkeywordsSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextInputEditText impkeywords = (TextInputEditText) findViewById(R.id.changeImpKeywordsInput);
                String impkeywords_string = impkeywords.getText().toString();
                System.out.println(impkeywords_string);

                if (impkeywords_string.length() > 0) {
                    ArrayList<String> keywords_list = new ArrayList<String>(Arrays.asList(impkeywords_string.split("\\s*,\\s*")));
                    for (int i = 0; i < keywords_list.size(); i++){
                        System.out.println("this is a word in keywords list: " + keywords_list.get(i));
                    }
                    filters.setImpKeywords(keywords_list);
                    g.setFilters(filters);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter replacement keywords if you'd like to make a change", Toast.LENGTH_SHORT).show();
                }
                TextView imp_keywords = findViewById(R.id.textView16);

                String imp_keywords_str = "";
                for (int i = 0; i < filters.getImpKeywords().size(); i++) {

                    if (i == filters.getImpKeywords().size() - 1) {
                        imp_keywords_str += filters.getImpKeywords().get(i);
                    } else {
                        imp_keywords_str += filters.getImpKeywords().get(i) + ", ";
                    }
                }
                imp_keywords.setText(imp_keywords_str);
            }
        });

        Button impKeywordsHomeButton = (Button)findViewById(R.id.impKeywordsHomeButton);
        impKeywordsHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent overview = new Intent(ChangeImpKeywordsSettingsActivity.this, HomePageActivity.class).putExtra("filters", filters);
                startActivity(overview);
            }
        });

    }

};
