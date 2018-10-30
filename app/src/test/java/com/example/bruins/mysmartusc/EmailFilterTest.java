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


public class EmailFilterTest {
    EmailFilters filter = new EmailFilters();

    @Before
    public void setUp() throws MessagingException {
        ArrayList<String> impemails = new ArrayList<String>();
        impemails.add("test@test.com");

        ArrayList<String> impsubject = new ArrayList<String>();
        impsubject.add("foo");

        ArrayList<String> impkeywords = new ArrayList<String>();
        impkeywords.add("bar");

        ArrayList<String> flags = new ArrayList<String>();
        flags.add("flag");

        filter.setImpEmails(impemails);
        filter.setImpSubwords(impsubject);
        filter.setImpKeywords(impkeywords);
        filter.setFlagwords(flags);
    }

    @Test
    public void CheckGetImportantEmails() throws IOException, MessagingException {
        assertEquals(filter.getImpEmails().size(), 1);
    }

    @Test
    public void CheckSetImportantEmails() throws IOException, MessagingException {
        ArrayList<String> new_imp_emails = new ArrayList<String>();;
        new_imp_emails.add("foo");
        new_imp_emails.add("bar");
        filter.setImpEmails(new_imp_emails);
        assertEquals(filter.getImpEmails().size(), 2);
    }

    @Test
    public void CheckGetImportantSubwords() throws IOException, MessagingException {
        assertEquals(filter.getImpSubwords().size(), 1);
    }

    @Test
    public void CheckSetImportantSubwords() throws IOException, MessagingException {
        ArrayList<String> new_imp_subwords = new ArrayList<String>();
        new_imp_subwords.add("foo");
        new_imp_subwords.add("bar");
        filter.setImpSubwords(new_imp_subwords);
        assertEquals(filter.getImpSubwords().size(), 2);
    }

    @Test
    public void CheckGetImportantKeywords() throws IOException, MessagingException {
        assertEquals(filter.getImpKeywords().size(), 1);
    }

    @Test
    public void CheckSetImportantKeywords() throws IOException, MessagingException {
        ArrayList<String> new_imp_keywords = new ArrayList<String>();
        new_imp_keywords.add("foo");
        new_imp_keywords.add("bar");
        filter.setImpKeywords(new_imp_keywords);
        assertEquals(filter.getImpKeywords().size(), 2);
    }

    @Test
    public void CheckGetFlagwords() throws IOException, MessagingException {
        assertEquals(filter.getFlagwords().size(), 1);
    }

    @Test
    public void CheckSetFlagwords() throws IOException, MessagingException {
        ArrayList<String> new_flagwords = new ArrayList<String>();
        new_flagwords.add("foo");
        new_flagwords.add("bar");
        filter.setFlagwords(new_flagwords);
        assertEquals(filter.getFlagwords().size(), 2);
    }
}
