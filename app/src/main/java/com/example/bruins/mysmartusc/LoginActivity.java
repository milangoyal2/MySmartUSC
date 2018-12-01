package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bruins.mysmartusc.EmailFilters;
import com.sun.mail.imap.IMAPStore;

import java.util.Properties;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;

public class LoginActivity extends AppCompatActivity {

    Button b1;
    EditText ed1, ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        TextView textView =(TextView)findViewById(R.id.textView11);
        TextView textBlurb =(TextView)findViewById(R.id.textBlurb);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "Note: If your google account has 2 Step Authorization, <a href='https://myaccount.google.com/apppasswords'>click here</a> to make an app password for this device. Use generated 16 character password in the field above";
        String blurb = "Overwhelmed by always getting email notifications?<br>" +
                "Want to parse out your life?<br>" +
                "Looking for <font color=\"red\">love</font>?<br>" +
                "MySmartUSC is a notification manager for busy USC students! " +
                "Add a list of emails and keywords you want to be notified for, and MySmartUSC will do the rest, only asking for your attention when it's a truly important moment of life.\n" +
                "Sign up to get started:";
        textView.setText(Html.fromHtml(text));
        textBlurb.setText(Html.fromHtml(blurb));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String user = ed1.getText().toString(); //usc email address
            String password = ed2.getText().toString(); //FOR USC: 16 character app password from google app passwords generator

            Toast.makeText(getApplicationContext(),
                    "Verifying email - might take some time...", Toast.LENGTH_SHORT).show();
            new LoginAsyncTask(LoginActivity.this, user, password).execute();
            }
        });
    }
}
