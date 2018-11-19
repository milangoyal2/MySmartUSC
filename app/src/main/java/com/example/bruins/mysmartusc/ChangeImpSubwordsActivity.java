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

    //returns the current important subwords
    protected String getCurrent(){
        String imp_subwords_str = "";
        for (int i = 0; i < filters.getImpSubwords().size(); i++) {

            if (i == filters.getImpSubwords().size() - 1) {
                imp_subwords_str += filters.getImpSubwords().get(i);
            } else {
                imp_subwords_str += filters.getImpSubwords().get(i) + ", ";
            }
        }
        return imp_subwords_str;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_impsubwords_settings_layout);

        TextView imp_subwords = findViewById(R.id.textView20);

        //displays the current important emails.
        imp_subwords.setText(getCurrent());

        //for parsing the newly entered unimportant emails
        Button changeImpEmailsSetButton = (Button)findViewById(R.id.impSubwordsSetButton);

        System.out.println(changeImpEmailsSetButton);
        changeImpEmailsSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpSubwordsInput);
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
                        ArrayList<String> old_list = filters.getImpSubwords();
                        for (int i = 0; i < new_list.size(); i++) {
                            if (!old_list.contains(new_list.get(i))) {
                                old_list.add(new_list.get(i));
                            }
                        }

                        filters.setImpSubwords(old_list);

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
                        g.setFilters(filters);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter replacement emails if you'd like to make a change", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button deleteButton = (Button)findViewById(R.id.deleteButton4);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpSubwordsInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>(Arrays.asList(newInputString.split("\\s*,\\s*")));
                    ArrayList<String> old_list = filters.getImpSubwords();
                    for (int i = 0; i < new_list.size(); i++) {
                        if (old_list.contains(new_list.get(i))) {
                            old_list.remove(new_list.get(i));
                        }
                    }

                    filters.setImpSubwords(old_list);

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
                    g.setFilters(filters);
                }
            }
        });

        Button clearButton = (Button)findViewById(R.id.clearButton4);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeImpSubwordsInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>();

                    filters.setImpSubwords(new_list);

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
                    g.setFilters(filters);
                }

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

//        protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.change_impsubwords_settings_layout);
//
//        TextView imp_subwords = findViewById(R.id.textView20);
//
//        //displays the current unimportant emails.
//        imp_subwords.setText(getCurrent());
//
//        //for parsing the newly entered unimportant emails
//        Button changeImpSubwordsSetButton = (Button)findViewById(R.id.changeImpSubwordsSetButton);
//        System.out.println(changeImpSubwordsSetButton);
//        changeImpSubwordsSetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                TextInputEditText impSubwords = (TextInputEditText) findViewById(R.id.changeImpSubwordsInput);
//                String impSubwords_string = impSubwords.getText().toString();
//                System.out.println(impSubwords_string);
//
//                if (impSubwords_string.length() > 0) {
//                    ArrayList<String> imp_subwords_list = new ArrayList<String>(Arrays.asList(impSubwords_string.split("\\s*,\\s*")));
//                    for (int i = 0; i < imp_subwords_list.size(); i++){
//                        System.out.println("this is a word in important subwords list: " + imp_subwords_list.get(i));
//                    }
//                    filters.setImpSubwords(imp_subwords_list);
//                    g.setFilters(filters);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enter replacement subject keywords if you'd like to make a change", Toast.LENGTH_SHORT).show();
//                }
//
//                TextView imp_subwords = findViewById(R.id.textView20);
//
//                String imp_subwords_str = "";
//                for (int i = 0; i < filters.getImpSubwords().size(); i++) {
//
//                    if (i == filters.getImpSubwords().size() - 1) {
//                        imp_subwords_str += filters.getImpSubwords().get(i);
//                    } else {
//                        imp_subwords_str += filters.getImpSubwords().get(i) + ", ";
//                    }
//                }
//                imp_subwords.setText(imp_subwords_str);
//            }
//        });

    }

};
