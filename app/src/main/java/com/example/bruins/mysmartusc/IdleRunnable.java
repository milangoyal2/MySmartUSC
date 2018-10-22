package com.example.bruins.mysmartusc;

import com.example.bruins.mysmartusc.NotificationSender;

import com.sun.mail.imap.IMAPFolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

public class IdleRunnable implements Runnable {
    private IMAPFolder folder;
    private NotificationSender notificationSender;
    private Thread keepAlive;
    private int lastMessage;



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



    public IdleRunnable(IMAPFolder folder, NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
        this.folder = folder;
        lastMessage = 0;
    }

    //returns int based on filters
    public int checkEmail(Message message) throws MessagingException, IOException {


        //return 1 for important email
        //return 2 for important word in subject line
        //return 3 for important word in content
        //return 0 for not important
        //return -1 for no match
        boolean found = false;
        boolean flags = false;

        EmailFilters mEmailFilters = Globals.getInstance().getFilters();
        ArrayList<String> impSubKeywords = mEmailFilters.getImpSubwords();
        ArrayList<String> impContKeywords = mEmailFilters.getImpKeywords();
        ArrayList<String> impEmails = mEmailFilters.getImpEmails();
        ArrayList<String> flagWords = mEmailFilters.getFlagwords();

        //imp emails
        for(int i =0; i < impEmails.size(); i++)
        {
            if(InternetAddress.toString(message.getFrom()).contains(impEmails.get(i)))
            {
                found = true;
            }
        }


        //imp subject keywords
        for(int i =0; i < impSubKeywords.size(); i++)
        {
            if(message.getSubject().contains(impSubKeywords.get(i)))
            {
                found = true;
            }
        }


        //imp cont keywords
        for(int i =0; i < impContKeywords.size(); i++)
        {
            if(getTextFromMessage(message).contains(impContKeywords.get(i)))
            {
                found = true;
            }
        }

        //imp flag keywords
        for(int i =0; i < flagWords.size(); i++)
        {
            if(getTextFromMessage(message).contains(flagWords.get(i))) {
                found = true;
                flags = true;
            }
        }

        if (found) {
            if (flags) {
                return 2;
            }
            return 1;
        }
        return -1;
    }

    @Override
    public void run(){
        // We need to create a new thread to keep alive the connection
        Thread t = new Thread(new KeepAliveRunnable(folder), "IdleConnectionKeepAlive");

        t.start();

        SearchTerm today = new ReceivedDateTerm(ComparisonTerm.GT,new GregorianCalendar().getTime());
        try {
            Message msgs[] = folder.search(today);
            lastMessage = msgs.length;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        while (!Thread.interrupted()) {
            //Starting IDLE
            try {
                System.out.println("STARTING IDLED@@@@@@@@@@@@@@@@@@@@@");
//                int messageCount = folder.getMessageCount();
//                Message message = folder.getMessage(messageCount);
//                System.out.println(message.getSubject());
                folder.idle();
                GregorianCalendar date = new GregorianCalendar();
                SearchTerm newer = new ReceivedDateTerm(ComparisonTerm.GT,date.getTime());
                Message msgs[] = folder.search(newer);
                int size = msgs.length;
                if (size != lastMessage) {
                    System.out.println("NEW EMAIL HAS BEEN RECEIVED@@@@@@@@@@@@@@@@@@@@@");


                    System.out.println("lastMessage:" + lastMessage + " size:" + size);




                    //loop over all incoming emails that might have arrived:
                    for (int i = lastMessage; i < size; i++) {
                        Message message = msgs[i];
                        System.out.println(message.getSubject());

                        int notificationType = 0;
                        // Parse message and send notification:
                        try {
                            notificationType = checkEmail(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            notificationSender.SendNotification(notificationType,"New Email from: " + InternetAddress.toString(message.getFrom()) ,"subject: " + message.getSubject(), getTextFromMessage(message));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    lastMessage = size;
                }
            } catch (MessagingException e) {
                //Messaging exception during IDLE
                throw new RuntimeException(e);
            }
        }

        // Shutdown keep alive thread
        if (t.isAlive()) {
            t.interrupt();
        }
    }
}
