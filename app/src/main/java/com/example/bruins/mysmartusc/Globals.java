package com.example.bruins.mysmartusc;

import javax.mail.Session;

public class Globals {
    private static Globals instance;

    // Global variable
    private Session session;
    private ServiceClass service;
    // Restrict the constructor from being instantiated
    private Globals(){
        session = null;
        service = null;
    }

    public void setSession(Session s){
        this.session = s;
    }
    public Session getSession(){
        return session;
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
