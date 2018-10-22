package com.example.bruins.mysmartusc;

import com.example.bruins.mysmartusc.NotificationSender;

import com.sun.mail.imap.IMAPFolder;

import java.io.IOException;
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

                        // Parse message and send notification:
                        try {
                            notificationSender.SendNotification(1,"New Email from: " + InternetAddress.toString(message.getFrom()) ,"subject: " + message.getSubject(), getTextFromMessage(message));
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
