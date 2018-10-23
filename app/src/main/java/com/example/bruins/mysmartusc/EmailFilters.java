package com.example.bruins.mysmartusc;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class EmailFilters implements Serializable {
    private ArrayList<String> impKeywords = new ArrayList<String>();
    private ArrayList<String> impEmails = new ArrayList<String>();
    private ArrayList<String> flagwords = new ArrayList<String>();
    private ArrayList<String> impSubwords = new ArrayList<String>();

    public ArrayList<String> getFlagwords() {
        return flagwords;
    }

    public void setFlagwords(ArrayList<String> flagwords) {
        this.flagwords = flagwords;
    }

    public ArrayList<String> getImpSubwords() {
        return impSubwords;
    }

    public void setImpSubwords(ArrayList<String> impSubwords) {
        this.impSubwords = impSubwords;
    }

    public ArrayList<String> getImpKeywords() {
        return impKeywords;
    }

    public void setImpKeywords(ArrayList<String> impKeywords) {
        this.impKeywords = impKeywords;
    }

    public ArrayList<String> getImpEmails() {
        return impEmails;
    }

    public void setImpEmails(ArrayList<String> impEmails) {
        this.impEmails = impEmails;
    }
}
