//package com.example.bruins.mysmartusc;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.TextInputEditText;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//
//public class ChangeUniEmailsSettingsActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.change_unimemails_settings_layout);
//
//        final EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
//
//        TextView unimp_emails = findViewById(R.id.textView10);
//
//        //displays the current unimportant emails.
//        String unimp_emails_str = "";
//        for (int i = 0; i < filters.getUnimpEmails().size(); i++) {
//
//            if (i == filters.getUnimpEmails().size() - 1) {
//                unimp_emails_str += filters.getUnimpEmails().get(i);
//            } else {
//                unimp_emails_str += filters.getUnimpEmails().get(i) + ", ";
//            }
//        }
//        unimp_emails.setText(unimp_emails_str);
//
//        //for parsing the newly entered unimportant emails
//        Button changeUnimEmailsSetButton = (Button)findViewById(R.id.changeUnimEmailsSetButton);
//        changeUnimEmailsSetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final TextInputEditText unimEmails = (TextInputEditText) findViewById(R.id.changeUnimEmailsInput);
//                String unimEmails_string = unimEmails.getText().toString();
//                System.out.println(unimEmails_string);
//
//                if (unimEmails_string.length() > 0) {
//                    ArrayList<String> emails_list = new ArrayList<String>(Arrays.asList(unimEmails_string.split("\\s*,\\s*")));
//                    for (int i = 0; i < emails_list.size(); i++){
//                        System.out.println("this is a word in emails list: " + emails_list.get(i));
//                    }
//                    filters.setUnimpEmails(emails_list);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enter replacement emails if you'd like to make a change", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        Button unimEmailHomeButton = (Button)findViewById(R.id.unimEmailHomeButton);
//        unimEmailHomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent overview = new Intent(ChangeUniEmailsSettingsActivity.this, FiltersOverviewActivity.class).putExtra("filters", filters);
//                startActivity(overview);
//
//            }
//        });
//
//    }
//
//};
