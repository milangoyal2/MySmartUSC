//package com.example.bruins.mysmartusc;
//
//import android.content.Intent;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//
//
//
//
//
//public class FiltersOverviewActivity extends AppCompatActivity {
//
//    TextView imp_emails, imp_keywords, unimp_emails, unimp_keywords;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_filters_overview);
//
//        Button SettingsButton = (Button)findViewById(R.id.settingsbutton);
//
//        imp_emails = findViewById(R.id.textView6);
//        imp_keywords = findViewById(R.id.textView7);
//        unimp_emails = findViewById(R.id.textView8);
//        unimp_keywords = findViewById(R.id.textView9);
//
//        EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
//
//        String imp_emails_str = "";
//        for (int i = 0; i < filters.getImpEmails().size(); i++) {
//
//
//            if (i == filters.getImpEmails().size() - 1) {
//                imp_emails_str += filters.getImpEmails().get(i);
//            } else {
//                imp_emails_str += filters.getImpEmails().get(i) + ", ";
//            }
//        }
//        imp_emails.setText(imp_emails_str);
//
//        String imp_keywords_str = "";
//        for (int i = 0; i < filters.getImpKeywords().size(); i++) {
//
//            if (i == filters.getImpKeywords().size() - 1) {
//                imp_keywords_str += filters.getImpKeywords().get(i);
//            } else {
//                imp_keywords_str += filters.getImpKeywords().get(i) + ", ";
//            }
//        }
//        imp_keywords.setText(imp_keywords_str);
//
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
//        String unimp_keywords_str = "";
//        for (int i = 0; i < filters.getUnimpKeywords().size(); i++) {
//
//            if (i == filters.getUnimpKeywords().size() - 1) {
//                unimp_keywords_str += filters.getUnimpKeywords().get(i);
//            } else {
//                unimp_keywords_str += filters.getUnimpKeywords().get(i) + ", ";
//            }
//
//            unimp_keywords.setText(unimp_keywords_str);
//        }
//        System.out.println("Resting something");
//        SettingsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Resting something");
//                EmailFilters filters = (EmailFilters) getIntent().getSerializableExtra("filters");
//                Intent changeSettingsIntent = new Intent(FiltersOverviewActivity.this, ChangeSettingsActivity.class).putExtra("filters", filters);
//                startActivity(changeSettingsIntent);
//            }
//        });
//    }
//}
