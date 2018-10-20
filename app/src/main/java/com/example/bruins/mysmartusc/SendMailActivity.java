package com.example.bruins.mysmartusc;

import android.app.Notification;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bruins.mysmartusc.NotificationUtils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.content.Context;

public class SendMailActivity extends AppCompatActivity {
    EditText edittext_recipient_id, edittext_subject, edittext_message;
    Button btn_send_mail;
    Button btn_notification;

    private NotificationUtils mNotificationUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
        //initialize view  by find view by id
        edittext_recipient_id = (EditText) findViewById(R.id.edittext_recipient_id);
        edittext_subject = (EditText) findViewById(R.id.edittext_subject);
        edittext_message = (EditText) findViewById(R.id.edittext_message);

        //set onclick listner on button
        btn_send_mail = findViewById(R.id.btn_send_mail);
        btn_send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get  input data from view
                String mRecipientMail = edittext_recipient_id.getText().toString();
                String mSubject = edittext_subject.getText().toString();
                String mMessage = edittext_message.getText().toString();
                new SendMailAsynTask(SendMailActivity.this, mRecipientMail, mSubject, mMessage).execute();//call send mail  cunstructor asyntask by  sending perameter
            }
        });

        btn_notification = findViewById(R.id.btn_notification);

        //Notification Builder:
        mNotificationUtils = new NotificationUtils(this);

        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder nb = mNotificationUtils.getAndroidChannelNotification("Hi", "There");
                mNotificationUtils.getManager().notify(101, nb.build());

//                String title = editTextTitleAndroid.getText().toString();
//                String author = editTextAuthorAndroid.getText().toString();
//
//                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(author)) {
//                    Notification.Builder nb = mNotificationUtils.
//                            getAndroidChannelNotification(title, "By " + author);
//
//                    mNotificationUtils.getManager().notify(101, nb.build());
//                }
            }
        });


    }


}
