package com.example.bruins.mysmartusc;

import com.sun.mail.imap.IMAPFolder;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ChangeSettingsTests {
    Globals g = Globals.getInstance();
    EmailFilters filters = g.getFilters();

    private ChangeFavFlagSettingsActivity favflagTestObject = new ChangeFavFlagSettingsActivity();
    private ChangeImpEmailsSettingsActivity emailsTestObject = new ChangeImpEmailsSettingsActivity();
    private ChangeImpKeywordsSettingsActivity keywordsTestObject =  new ChangeImpKeywordsSettingsActivity();
    private ChangeImpSubwordsActivity subwordsTestObject = new ChangeImpSubwordsActivity();

    @Before
    public void setUp(){

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
    }

    @Test
    public void CheckCurrentEmailsSingleton() throws IOException {
        String returnString = "test@test.com";
        assertEquals(emailsTestObject.getCurrent(), returnString);
    }
    @Test
    public void CheckCurrentEmails() throws IOException {
        ArrayList<String> emails = new ArrayList<String>();
        emails.add("test1@test.com");
        emails.add("test2@test.com");
        EmailFilters newfilter = g.getFilters();
        newfilter.setImpEmails(emails);
        g.setFilters(newfilter);

        String returnString = "test1@test.com, test2@test.com";
        assertEquals(emailsTestObject.getCurrent(), returnString);
    }

    @Test
    public void CheckCurrentSubwordsSingleton() throws IOException {
        String returnString = "foo";
        assertEquals(subwordsTestObject.getCurrent(), returnString);
    }
    @Test
    public void CheckCurrentSubwords() throws IOException {
        ArrayList<String> subwords = new ArrayList<String>();
        subwords.add("foo1");
        subwords.add("foo2");
        EmailFilters newfilter = g.getFilters();
        newfilter.setImpSubwords(subwords);
        g.setFilters(newfilter);

        String returnString = "foo1, foo2";
        assertEquals(subwordsTestObject.getCurrent(), returnString);
    }

    @Test
    public void CheckCurrentKeywordsSingleton() throws IOException {
        String returnString = "bar";
        assertEquals(keywordsTestObject.getCurrent(), returnString);
    }
    @Test
    public void CheckCurrentKeywords() throws IOException {
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("bar1");
        keywords.add("bar2");
        EmailFilters newfilter = g.getFilters();
        newfilter.setImpKeywords(keywords);
        g.setFilters(newfilter);

        String returnString = "bar1, bar2";
        assertEquals(keywordsTestObject.getCurrent(), returnString);
    }

    @Test
    public void CheckCurrentFlagsSingleton() throws IOException {
        String returnString = "flag";
        assertEquals(favflagTestObject.getCurrent(), returnString);
    }
    @Test
    public void CheckCurrentFlags() throws IOException {
        ArrayList<String> flags = new ArrayList<String>();
        flags.add("flag1");
        flags.add("flag2");
        EmailFilters newfilter = g.getFilters();
        newfilter.setFlagwords(flags);
        g.setFilters(newfilter);

        String returnString = "flag1, flag2";
        assertEquals(favflagTestObject.getCurrent(), returnString);
    }

}
