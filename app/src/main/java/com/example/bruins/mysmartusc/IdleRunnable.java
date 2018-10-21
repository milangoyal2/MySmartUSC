package com.example.bruins.mysmartusc;

import com.sun.mail.imap.IMAPFolder;

import java.util.GregorianCalendar;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

public class IdleRunnable implements Runnable {
    private IMAPFolder folder;
    private Thread keepAlive;
    private int lastMessage;

    public IdleRunnable(IMAPFolder folder) {
        this.folder = folder;
        lastMessage = 0;
    }

    @Override
    public void run(){
        // We need to create a new thread to keep alive the connection
        Thread t = new Thread(new KeepAliveRunnable(folder), "IdleConnectionKeepAlive");

        t.start();

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
                    System.out.println(msgs[size-1].getSubject());
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
