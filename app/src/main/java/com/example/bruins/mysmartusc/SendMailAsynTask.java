package com.example.bruins.mysmartusc;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Store;

/**
 * Created by ps205 on 3/1/17.
 */
public class SendMailAsynTask extends AsyncTask<Void, Void, Void> {
    //Declaring Variables
    private Context context;
    private Session session;
    //Information to send email
    private String email;
    private String subject;
    private String message;
    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;
    //Class Constructor
    public SendMailAsynTask(Context context, String email, String subject, String message) {
        //Initializing variables
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context, "Sending message", "Please wait...", false, false);
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context, "Message Sent", Toast.LENGTH_LONG).show();
    }
    @Override
    protected Void doInBackground(Void... params) {

        //Creating properties
        Properties props = new Properties();
        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values

          props.put("mail.store.protocol", "imaps");

        //Creating a new session
        Session session = Session.getDefaultInstance(props,null);
        try {

            //retrieve email
            Store store = session.getStore("imaps");
            String host = "imap.googlemail.com";
            String user = "mysmartusctest@gmail.com";//usc email address
            String password = "mysmartusctest5*";//FOR USC: 16 character app password from google app passwords generator
            store.connect(host, user, password);

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            // print emails
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

        }catch (NoSuchProviderException e) {
        e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}