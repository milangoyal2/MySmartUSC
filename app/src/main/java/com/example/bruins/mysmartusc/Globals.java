package com.example.bruins.mysmartusc;

import com.sun.mail.imap.IMAPStore;

import javax.mail.Session;

public class Globals {
    private static Globals instance;

    // Global variable
    private IMAPStore store;
    private ServiceClass service;
    // Restrict the constructor from being instantiated
    private Globals(){
        store = null;
        service = null;
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

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
