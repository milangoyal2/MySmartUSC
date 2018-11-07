package com.example.bruins.mysmartusc;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ChangeFavFlagSettingsActivity extends AppCompatActivity {

    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    //returns the current flagwords
    protected String getCurrent(){
        String fav_flags_str = "";
        for (int i = 0; i < filters.getFlagwords().size(); i++) {

            if (i == filters.getFlagwords().size() - 1) {
                fav_flags_str += filters.getFlagwords().get(i);
            } else {
                fav_flags_str += filters.getFlagwords().get(i) + ", ";
            }
        }
        return fav_flags_str;
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_favflag_settings_layout);

        TextView fav_flags = findViewById(R.id.textView12);

        //displays the current important emails.
        fav_flags.setText(getCurrent());

        //for parsing the newly entered unimportant emails
        Button changeFavFlagsSetButton = (Button)findViewById(R.id.FavFlagsSetButton);

        System.out.println(changeFavFlagsSetButton);
        changeFavFlagsSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeFavFlagInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>(Arrays.asList(newInputString.split("\\s*,\\s*")));
                    ArrayList<String> old_list = filters.getFlagwords();
                    for (int i = 0; i < new_list.size(); i++) {
                        if (!old_list.contains(new_list.get(i))) {
                            old_list.add(new_list.get(i));
                        }
                    }

                    filters.setFlagwords(old_list);

                    TextView fav_flags = findViewById(R.id.textView12);

                    String fav_flags_str = "";
                    for (int i = 0; i < filters.getFlagwords().size(); i++) {

                        if (i == filters.getFlagwords().size() - 1) {
                            fav_flags_str += filters.getFlagwords().get(i);
                        } else {
                            fav_flags_str += filters.getFlagwords().get(i) + ", ";
                        }
                    }
                    fav_flags.setText(fav_flags_str);
                    g.setFilters(filters);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter replacement emails if you'd like to make a change", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button deleteButton = (Button)findViewById(R.id.deleteButton2);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeFavFlagInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>(Arrays.asList(newInputString.split("\\s*,\\s*")));
                    ArrayList<String> old_list = filters.getFlagwords();
                    for (int i = 0; i < new_list.size(); i++) {
                        if (old_list.contains(new_list.get(i))) {
                            old_list.remove(new_list.get(i));
                        }
                    }

                    filters.setFlagwords(old_list);

                    TextView fav_flags = findViewById(R.id.textView12);

                    String fav_flags_str = "";
                    for (int i = 0; i < filters.getFlagwords().size(); i++) {

                        if (i == filters.getFlagwords().size() - 1) {
                            fav_flags_str += filters.getFlagwords().get(i);
                        } else {
                            fav_flags_str += filters.getFlagwords().get(i) + ", ";
                        }
                    }
                    fav_flags.setText(fav_flags_str);
                    g.setFilters(filters);
                }

            }
        });

        Button clearButton = (Button)findViewById(R.id.clearButton2);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newInput = (TextInputEditText) findViewById(R.id.changeFavFlagInput);
                String newInputString = newInput.getText().toString();

                if (newInputString.length() > 0) {
                    ArrayList<String> new_list = new ArrayList<String>();

                    filters.setFlagwords(new_list);

                    TextView fav_flags = findViewById(R.id.textView12);

                    String fav_flags_str = "";
                    for (int i = 0; i < filters.getFlagwords().size(); i++) {

                        if (i == filters.getFlagwords().size() - 1) {
                            fav_flags_str += filters.getFlagwords().get(i);
                        } else {
                            fav_flags_str += filters.getFlagwords().get(i) + ", ";
                        }
                    }
                    fav_flags.setText(fav_flags_str);
                    g.setFilters(filters);
                }

            }
        });


//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.change_favflag_settings_layout);
//
//        TextView fav_flags = findViewById(R.id.textView12);
//
//        //displays the current flagwords
//        fav_flags.setText(getCurrent());
//
//        //for parsing the newly entered unimportant emails
//        Button changeFavFlagsSetButton = (Button)findViewById(R.id.changeFavFlagClearButton);
//        System.out.println(changeFavFlagsSetButton);
//        changeFavFlagsSetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView fav_flags = findViewById(R.id.textView12);
//                TextInputEditText favFlags = (TextInputEditText) findViewById(R.id.changeFavFlagInput);
//                String favFlags_string = favFlags.getText().toString();
////                System.out.println(favFlags_string);
////
//                if (favFlags_string.length() > 0) {
////                    ArrayList<String> fav_flags_list = new ArrayList<String>(Arrays.asList(favFlags_string.split("\\s*,\\s*")));
////                    for (int i = 0; i < fav_flags_list.size(); i++){
////                        System.out.println("this is a word in Fav/Flags list: " + fav_flags_list.get(i));
////                    }
////                    filters.setFlagwords(fav_flags_list);
////                    g.setFilters(filters);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enter replacement Fav/Flag keywords if you'd like to make a change", Toast.LENGTH_SHORT).show();
//                }
//
//
//
//                String fav_flags_str = "";
////                for (int i = 0; i < filters.getFlagwords().size(); i++) {
////
////                    if (i == filters.getFlagwords().size() - 1) {
////                        fav_flags_str += filters.getFlagwords().get(i);
////                    } else {
////                        fav_flags_str += filters.getFlagwords().get(i) + ", ";
////                    }
////                }
//                fav_flags.setText(fav_flags_str);
//                ArrayList<String> fav_flags_list = new ArrayList<String>(Arrays.asList(""));
//                filters.setFlagwords(fav_flags_list);
//            }
//        });
//
//        Button impFavFlagHomeButton = (Button)findViewById(R.id.favFlagHomeButton);
//        impFavFlagHomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent overview = new Intent(ChangeFavFlagSettingsActivity.this, HomePageActivity.class);
//                startActivity(overview);
//            }
//        });

    }

};
