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


public class ChangeImpEmailsSettingsActivity extends AppCompatActivity {

    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    protected String getCurrent(){
        String imp_emails_str = "";
        for (int i = 0; i < filters.getImpEmails().size(); i++) {

            if (i == filters.getImpEmails().size() - 1) {
                imp_emails_str += filters.getImpEmails().get(i);
            } else {
                imp_emails_str += filters.getImpEmails().get(i) + ", ";
            }
        }
        return imp_emails_str;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_impemails_settings_layout);

        TextView imp_emails = findViewById(R.id.textView14);

        //displays the current important emails.
        imp_emails.setText(getCurrent());

        //for parsing the newly entered unimportant emails
        Button changeImpEmailsSetButton = (Button)findViewById(R.id.impEmailsSetButton);

        System.out.println(changeImpEmailsSetButton);
        changeImpEmailsSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpEmailsInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>(Arrays.asList(newInputString.split("\\s*,\\s*")));
                    ArrayList<String> old_list = filters.getImpEmails();
                    for (int i = 0; i < new_list.size(); i++) {
                        if (!old_list.contains(new_list.get(i))) {
                            old_list.add(new_list.get(i));
                        }
                    }

                    filters.setImpEmails(old_list);

                    TextView imp_emails = findViewById(R.id.textView14);

                    String imp_emails_str = "";
                    for (int i = 0; i < filters.getImpEmails().size(); i++) {

                        if (i == filters.getImpEmails().size() - 1) {
                            imp_emails_str += filters.getImpEmails().get(i);
                        } else {
                            imp_emails_str += filters.getImpEmails().get(i) + ", ";
                        }
                    }
                    imp_emails.setText(imp_emails_str);
                    g.setFilters(filters);
            } else {
                Toast.makeText(getApplicationContext(), "Please enter replacement emails if you'd like to make a change", Toast.LENGTH_SHORT).show();
            }

            }
        });

        Button deleteButton = (Button)findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpEmailsInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>(Arrays.asList(newInputString.split("\\s*,\\s*")));

                    boolean error = false;
                    for (int i = 0; i < new_list.size(); i++) {
                        if (new_list.get(i).contains(" ")) {
                            error = true;
                            Toast.makeText(getApplicationContext(), "Improper formatting in list...",Toast.LENGTH_SHORT).show();
                        }
                    }

                    if (!error) {
                        ArrayList<String> old_list = filters.getImpEmails();
                        for (int i = 0; i < new_list.size(); i++) {
                            if (old_list.contains(new_list.get(i))) {
                                old_list.remove(new_list.get(i));
                            }
                        }

                        filters.setImpEmails(old_list);

                        TextView imp_emails = findViewById(R.id.textView14);

                        String imp_emails_str = "";
                        for (int i = 0; i < filters.getImpEmails().size(); i++) {

                            if (i == filters.getImpEmails().size() - 1) {
                                imp_emails_str += filters.getImpEmails().get(i);
                            } else {
                                imp_emails_str += filters.getImpEmails().get(i) + ", ";
                            }
                        }
                        imp_emails.setText(imp_emails_str);
                        g.setFilters(filters);
                    }

                }

            }
        });

        Button clearButton = (Button)findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpEmailsInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>();

                    filters.setImpEmails(new_list);

                    TextView imp_emails = findViewById(R.id.textView14);

                    String imp_emails_str = "";
                    for (int i = 0; i < filters.getImpEmails().size(); i++) {

                        if (i == filters.getImpEmails().size() - 1) {
                            imp_emails_str += filters.getImpEmails().get(i);
                        } else {
                            imp_emails_str += filters.getImpEmails().get(i) + ", ";
                        }
                    }
                    imp_emails.setText(imp_emails_str);
                    g.setFilters(filters);
                }

            }
        });


        Button impEmailHomeButton = (Button)findViewById(R.id.impEmailHomeButton);
        impEmailHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent overview = new Intent(ChangeImpEmailsSettingsActivity.this, HomePageActivity.class).putExtra("filters", filters);
                startActivity(overview);
            }
        });
    }
};
