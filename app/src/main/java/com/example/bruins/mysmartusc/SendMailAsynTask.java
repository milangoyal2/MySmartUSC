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
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");

        props.put("mail.pop3.host", "pop.gmail.com");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.starttls.enable", "true");

        //Creating a new session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mysmartusctest@gmail.com", "mysmartusctest5*");
                    }
                });
        try {

            //retrieve email
            Store store = session.getStore("pop3s");
            String host = "pop.gmail.com";
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



//            //Creating MimeMessage object
//            MimeMessage mm = new MimeMessage(session);
//            //Setting sender address
//            mm.setFrom(new InternetAddress("mysmartusctest@gmail.com"));
//            //Adding receiver
//            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//            //Adding subject
//            mm.setSubject(subject);
//            //Adding message
//            mm.setText(message);
//            //Sending email
//            Transport.send(mm);
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