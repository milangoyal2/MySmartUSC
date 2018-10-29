package com.example.bruins.mysmartusc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.Folder;
import javax.mail.Store;


public class HomePageActivity extends AppCompatActivity {

    Button startButton, stopButton, statusButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_listening);

        startButton = findViewById(R.id.button2);
        stopButton = findViewById(R.id.button3);
        statusButton = findViewById(R.id.button4);
        nextButton = findViewById(R.id.button5);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getService() != null) {
                    Globals.getInstance().getService().onDestroy();
                }
//                NotificationUtils mNotificationUtils = new NotificationUtils(HomePageActivity.this);
//                NotificationSender mySender = new NotificationSender(mNotificationUtils);
//                Store store = Globals.getInstance().getStore();
//                try {
//                    IMAPFolder emailFolder = (IMAPFolder) store.getFolder("INBOX");
//                    emailFolder.open(Folder.READ_WRITE);
//                    ServiceClass service = new ServiceClass(emailFolder, mySender);
//                    Globals.getInstance().setService(service);
//                    service.onStartCommand(null, 0, 1);
//                } catch (javax.mail.MessagingException e) {
//                    e.printStackTrace();
//                }
                new StartServiceAsyncTask(HomePageActivity.this).execute();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getService() != null) {
                    Globals.getInstance().getService().onDestroy();
                }
            }
        });

        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getService() != null) {
                    //We are listening
                    Toast.makeText(getApplicationContext(),
                            "Listening to Emails...", Toast.LENGTH_SHORT).show();
                }
                else {
                    //We are not listening
                    Toast.makeText(getApplicationContext(),
                            "Not Listening to Emails...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ChangeSettingsActivity.class);
                startActivity(intent);
            }
        });
    }


}
