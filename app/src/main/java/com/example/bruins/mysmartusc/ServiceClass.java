package com.example.bruins.mysmartusc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.sun.mail.imap.IMAPFolder;

public class ServiceClass extends Service {
    private Thread t;
    private IMAPFolder folder;

    public ServiceClass(IMAPFolder folder) {
        this.folder = folder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //start new thread here
        t = new Thread(new IdleRunnable(folder));
        t.start();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onDestroy() {
        t.interrupt();
        t = null;
        super.onDestroy();
    }


}
