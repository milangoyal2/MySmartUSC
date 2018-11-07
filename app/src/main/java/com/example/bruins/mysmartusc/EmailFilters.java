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

    public void addFlagword(String flagword) {
        if (!flagwords.contains(flagword)) {
            flagwords.add(flagword);
        }
    }

    public void deleteFlagword(String flagword) {
        for (int i = 0; i < flagwords.size(); i++) {
            if (flagwords.get(i).equals(flagword)) {
                flagwords.remove(i);
            }
        }
    }

    public ArrayList<String> getImpSubwords() {
        return impSubwords;
    }

    public void setImpSubwords(ArrayList<String> impSubwords) {
        this.impSubwords = impSubwords;
    }

    public void addImpSubword(String subword) {
        if (!impSubwords.contains(subword)) {
            impSubwords.add(subword);
        }
    }

    public void deleteImpSubword(String subword) {
        for (int i = 0; i < impSubwords.size(); i++) {
            if (impSubwords.get(i).equals(subword)) {
                impSubwords.remove(i);
            }
        }
    }

    public ArrayList<String> getImpKeywords() {
        return impKeywords;
    }

    public void setImpKeywords(ArrayList<String> impKeywords) {
        this.impKeywords = impKeywords;
    }

    public void addImpKeyword(String keyword) {
        if (!impKeywords.contains(keyword)) {
            impKeywords.add(keyword);
        }
    }

    public void deleteImpKeyword(String keyword) {
        for (int i = 0; i < impKeywords.size(); i++) {
            if (impKeywords.get(i).equals(keyword)) {
                impKeywords.remove(i);
            }
        }
    }

    public ArrayList<String> getImpEmails() {
        return impEmails;
    }

    public void setImpEmails(ArrayList<String> impEmails) {
        this.impEmails = impEmails;
    }

    public void addImpEmail(String email) {
        if (!impEmails.contains(email)) {
            impEmails.add(email);
        }
    }

    public void deleteImpEmail(String email) {
        for (int i = 0; i < impEmails.size(); i++) {
            if (impEmails.get(i).equals(email)) {
                impEmails.remove(i);
            }
        }
    }
}
