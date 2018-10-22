package com.example.bruins.mysmartusc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

public class LoginAsyncTask extends AsyncTask<Void, Void, Void> {
    private Context currContext;
    private String email;
    private String password;
    private boolean success;

    public LoginAsyncTask(Context currContext, String email, String password) {
        this.currContext = currContext;
        this.email = email;
        this.password = password;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (success) {
            // move to next layout:
            Intent intent = new Intent(currContext, ImportantSettingsActivity.class);

            currContext.startActivity(intent);
        } else {
            Toast.makeText(currContext,
                "Redirecting...", Toast.LENGTH_SHORT).show();

        }
        //Pass filters:
        //intent.putExtra("filters", myFilters);

    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();
        //Configuring properties for gmail
        props.put("mail.store.protocol", "imaps");

        //Creating a new session
        Session session = Session.getDefaultInstance(props, null);
        try {

            //retrieve email
            IMAPStore store = (IMAPStore) session.getStore("imaps");
            String host = "imap.googlemail.com";

            try {
                store.connect(host, email, password);
                Globals g = Globals.getInstance();
                g.setStore(store);

                success = true;
            } catch (Exception e) {
//                Toast.makeText(currContext,
//                        "Incorrect E-Mail/Password", Toast.LENGTH_SHORT).show();
                //System.out.println("INCORRECT PASSWORD");
                success = false;
                return null;
            }
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
