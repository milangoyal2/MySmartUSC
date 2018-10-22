package com.example.bruins.mysmartusc;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class EmailFilters implements Serializable {
    private ArrayList<String> impKeywords;
//    private ArrayList<String> unimpKeywords;
    private ArrayList<String> impEmails;
    private ArrayList<String> flagwords;

//    private ArrayList<String> unimpEmails;
    private ArrayList<String> impSubwords;
//    private ArrayList<String> unimpSubwords;

//    public ArrayList<String> getUnimpSubwords() {
//        return unimpSubwords;
//    }

//    public void setUnimpSubwords(ArrayList<String> unimpSubwords) {
//        this.unimpSubwords = unimpSubwords;
//    }

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

//    public ArrayList<String> getUnimpKeywords() {
//        return unimpKeywords;
//    }

//    public void setUnimpKeywords(ArrayList<String> unimpKeywords) {
//        this.unimpKeywords = unimpKeywords;
//    }

    public ArrayList<String> getImpEmails() {
        return impEmails;
    }

    public void setImpEmails(ArrayList<String> impEmails) {
        this.impEmails = impEmails;
    }

//    public ArrayList<String> getUnimpEmails() {
//        return unimpEmails;
//    }

//    public void setUnimpEmails(ArrayList<String> unimpEmails) {
//        this.unimpEmails = unimpEmails;
//    }
}
