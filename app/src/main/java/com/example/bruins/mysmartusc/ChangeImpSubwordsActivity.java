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


public class ChangeImpSubwordsActivity extends AppCompatActivity {

    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_impsubwords_settings_layout);

        TextView imp_subwords = findViewById(R.id.textView20);

        //displays the current unimportant emails.
        String imp_subwords_str = "";
        for (int i = 0; i < filters.getImpSubwords().size(); i++) {

            if (i == filters.getImpSubwords().size() - 1) {
                imp_subwords_str += filters.getImpSubwords().get(i);
            } else {
                imp_subwords_str += filters.getImpSubwords().get(i) + ", ";
            }
        }
        imp_subwords.setText(imp_subwords_str);

        //for parsing the newly entered unimportant emails
        Button changeImpSubwordsSetButton = (Button)findViewById(R.id.changeImpSubwordsSetButton);
        System.out.println(changeImpSubwordsSetButton);
        changeImpSubwordsSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputEditText impSubwords = (TextInputEditText) findViewById(R.id.changeImpSubwordsInput);
                String impSubwords_string = impSubwords.getText().toString();
                System.out.println(impSubwords_string);

                if (impSubwords_string.length() > 0) {
                    ArrayList<String> imp_subwords_list = new ArrayList<String>(Arrays.asList(impSubwords_string.split("\\s*,\\s*")));
                    for (int i = 0; i < imp_subwords_list.size(); i++){
                        System.out.println("this is a word in important subwords list: " + imp_subwords_list.get(i));
                    }
                    filters.setImpSubwords(imp_subwords_list);
                    g.setFilters(filters);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter replacement subject keywords if you'd like to make a change", Toast.LENGTH_SHORT).show();
                }

                TextView imp_subwords = findViewById(R.id.textView20);

                String imp_subwords_str = "";
                for (int i = 0; i < filters.getImpSubwords().size(); i++) {

                    if (i == filters.getImpSubwords().size() - 1) {
                        imp_subwords_str += filters.getImpSubwords().get(i);
                    } else {
                        imp_subwords_str += filters.getImpSubwords().get(i) + ", ";
                    }
                }
                imp_subwords.setText(imp_subwords_str);
            }
        });

        Button impSubwordsHomeButton = (Button)findViewById(R.id.impSubwordsHomeButton);
        impSubwordsHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent overview = new Intent(ChangeImpSubwordsActivity.this, HomePageActivity.class);
                startActivity(overview);
            }
        });

    }

};
