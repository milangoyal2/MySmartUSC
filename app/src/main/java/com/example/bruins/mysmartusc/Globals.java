package com.example.bruins.mysmartusc;

import com.sun.mail.imap.IMAPStore;

import javax.mail.Session;

public class Globals {
    private static Globals instance;

    // Global variable
    private IMAPStore store;
    private ServiceClass service;
    private EmailFilters filters;
    // Restrict the constructor from being instantiated
    private Globals(){
        store = null;
        service = null;
        filters = null;
    }

    public void setStore(IMAPStore s){
        this.store = s;
    }
    public IMAPStore getStore(){
        return store;
    }
    public void setService(ServiceClass s) {
        this.service = s;
    }
    public ServiceClass getService(){
        return service;
    }
    public EmailFilters getFilters() {
        return filters;
    }
    public void setFilters(EmailFilters filters) {
        this.filters = filters;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
