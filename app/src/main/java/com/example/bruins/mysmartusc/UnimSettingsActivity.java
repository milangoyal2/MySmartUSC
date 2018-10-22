//package com.example.bruins.mysmartusc;
//import com.example.bruins.mysmartusc.EmailFilters;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//
//public class UnimSettingsActivity extends AppCompatActivity {
//
//    Button nextButton;
//    EditText emails, contwords, subwords;
//    TextView header;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_unim_settings);
//
//        header = (TextView)findViewById(R.id.textView);
//        nextButton = (Button)findViewById(R.id.nextButton);
//
//        emails = (EditText)findViewById(R.id.emails);
//        contwords = (EditText)findViewById(R.id.contwords);
//        subwords = (EditText)findViewById(R.id.subwords);
//
//
//        String myHeader = "Enter keywords and emails for which you don't want notifications";
//        header.setText(myHeader);
//
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String string_emails = emails.getText().toString();
//                String string_contwords = contwords.getText().toString();
//                String string_subwords = subwords.getText().toString();
//
//                if(!string_emails.isEmpty() &&
//                        !string_subwords.isEmpty() && !string_contwords.isEmpty()) {
//                    //gets current global EmailFilters variable
//                    Globals g = Globals.getInstance();
//                    EmailFilters filters = g.getFilters();
//
//                    // Parse text and populate filters class:
//                    ArrayList<String> emails_list = new ArrayList<String>
//                            (Arrays.asList(string_emails.split("\\s*,\\s*")));
//                    ArrayList<String> contwords_list = new ArrayList<String>
//                            (Arrays.asList(string_contwords.split("\\s*,\\s*")));
//                    ArrayList<String> subwords_list = new ArrayList<String>
//                            (Arrays.asList(string_subwords.split("\\s*,\\s*")));
//
//                    filters.setUnimpEmails(emails_list);
//                    filters.setUnimpKeywords(contwords_list);
//                    filters.setUnimpSubwords(subwords_list);
//
//                    g.setFilters(filters);
//
//                    // move to next layout:
//                    Toast.makeText(getApplicationContext(),
//                            "Redirecting...",Toast.LENGTH_SHORT).show();
//                    Intent overview = new Intent(UnimSettingsActivity.this, FiltersOverviewActivity.class).putExtra("filters", filters);
//                    startActivity(overview);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Fields can't be empty",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
