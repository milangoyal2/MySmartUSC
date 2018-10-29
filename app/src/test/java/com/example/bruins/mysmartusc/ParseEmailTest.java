package com.example.bruins.mysmartusc;
import com.example.bruins.mysmartusc.IdleRunnable;
import com.sun.mail.imap.IMAPFolder;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;


public class ParseEmailTest {
    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    private Session session;
    private Message importantmessage;
    private Message flagMessage;
    private Message unimportantmessage;
    private Message caseInsensitive;
    private IdleRunnable testObject;
    private IMAPFolder folder;
    private NotificationSender notificationSender;


//    @Test
//    public void helloWorld() {
//        assertEquals(1,1);
//    }

    @Before
    public void setUp() throws MessagingException {
        //Creating properties
        Properties props = new Properties();
        //Configuring properties for gmail
        props.put("mail.store.protocol", "imaps");
        //Creating a new session
        session = Session.getDefaultInstance(props, null);

        ArrayList<String> impemails = new ArrayList<String>();
        impemails.add("test@test.com");

        ArrayList<String> impsubject = new ArrayList<String>();
        impsubject.add("foo");

        ArrayList<String> impkeywords = new ArrayList<String>();
        impkeywords.add("bar");

        ArrayList<String> flags = new ArrayList<String>();
        flags.add("flag");

        filters.setImpEmails(impemails);
        filters.setImpSubwords(impsubject);
        filters.setImpKeywords(impkeywords);
        filters.setFlagwords(flags);
        g.setFilters(filters);

        importantmessage = new MimeMessage(session);
        importantmessage.setFrom(new InternetAddress("test@test.com"));
        importantmessage.setSubject("foo");
        importantmessage.setText("bar");

        flagMessage = new MimeMessage(session);
        flagMessage.setFrom(new InternetAddress("someaddress@cool.com"));
        flagMessage.setSubject("oof");
        flagMessage.setText("flag");

//        unimportantmessage = flagMessage;
//        unimportantmessage.setText("something");\

        unimportantmessage = new MimeMessage(session);
        unimportantmessage.setFrom(new InternetAddress("rip@rip.com"));
        unimportantmessage.setSubject("ayy");
        unimportantmessage.setText("dolittle");


        caseInsensitive = flagMessage;
        caseInsensitive.setText("Flag");


        testObject = new IdleRunnable(folder, notificationSender);

        //throw new RuntimeException("Sorry dude, you won't find any test!");

    }

    @Test
    public void checkImportantEmail() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(importantmessage), 1);
    }

    @Test
    public void checkImportantSubject() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(importantmessage), 1);
    }

    @Test
    public void CheckImportantKeyword() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(importantmessage), 1);
    }

    @Test
    public void CheckFlags() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(flagMessage), 2);
    }

    @Test
    public void CheckUnimportantEmail() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(unimportantmessage), -1);
    }

    @Test
    public void CheckCaseInsensitivity() throws IOException, MessagingException {
        assertEquals(testObject.checkEmail(caseInsensitive), 2);
    }
}
