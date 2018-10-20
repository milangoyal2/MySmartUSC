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

    //retrieve email text from message object
    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    //helps retrieve email text from message object
    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

    //returns int based on filters
    public int checkEmail(Message message, ArrayList<String> impSubKeywords,ArrayList<String> unimpSubKeywords,
                          ArrayList<String> impContKeywords, ArrayList<String> unimpContKeywords, ArrayList<String> impEmails,
                          ArrayList<String> unimpEmails) throws MessagingException, IOException {
        //return 1 for important email
        //return 2 for important word in subject line
        //return 3 for important word in content
        //return 0 for not important
        //return -1 for no match

        //imp emails
        for(int i =0; i < impEmails.size(); i++)
        {
            if(InternetAddress.toString(message.getFrom()).contains(impEmails.get(i)))
            {
                return 1;
            }
        }
        //unimp emails
        for(int i =0; i < unimpEmails.size(); i++)
        {
            if(InternetAddress.toString(message.getFrom()).contains(unimpEmails.get(i)))
            {
                return -0;
            }
        }

        //imp subject keywords
        for(int i =0; i < impSubKeywords.size(); i++)
        {
            if(message.getSubject().contains(impSubKeywords.get(i)))
            {
                return 2;
            }
        }
        //unimp subject keywords
        for(int i =0; i < unimpSubKeywords.size(); i++)
        {
            if(message.getSubject().contains(unimpSubKeywords.get(i)))
            {
                return 0;
            }
        }

        //imp cont keywords
        for(int i =0; i < impContKeywords.size(); i++)
        {
            if(getTextFromMessage(message).contains(impContKeywords.get(i)))
            {
                return 3;
            }
        }
        //unimp cont keywords
        for(int i =0; i < unimpContKeywords.size(); i++)
        {
            if(getTextFromMessage(message).contains(unimpContKeywords.get(i)))
            {
                return 0;
            }
        }
        return -1;
    }

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

            // retrieve the latest messages from the folder
            int messageCount = emailFolder.getMessageCount();
            Message messages = emailFolder.getMessage(messageCount);

            // print email
            Message message = messages[i];
            System.out.println("---------------------------------");
            System.out.println("Email Number " + (i + 1));
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);
            System.out.println("Text: " + message.getContent().toString());

            //checkEmail(message, *ALL THE KEYWORD ARRAYS*) will return an int
            //int will correspond to which filtered message
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