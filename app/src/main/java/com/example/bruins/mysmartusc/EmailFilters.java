package com.example.bruins.mysmartusc;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class EmailFilters implements Serializable {
    private ArrayList<String> impKeywords, unimpKeywords, impEmails, unimpEmails;

    public ArrayList<String> getImpKeywords() {
        return impKeywords;
    }

    public void setImpKeywords(ArrayList<String> impKeywords) {
        this.impKeywords = impKeywords;
    }

    public ArrayList<String> getUnimpKeywords() {
        return unimpKeywords;
    }

    public void setUnimpKeywords(ArrayList<String> unimpKeywords) {
        this.unimpKeywords = unimpKeywords;
    }

    public ArrayList<String> getImpEmails() {
        return impEmails;
    }

    public void setImpEmails(ArrayList<String> impEmails) {
        this.impEmails = impEmails;
    }

    public ArrayList<String> getUnimpEmails() {
        return unimpEmails;
    }

    public void setUnimpEmails(ArrayList<String> unimpEmails) {
        this.unimpEmails = unimpEmails;
    }
}
