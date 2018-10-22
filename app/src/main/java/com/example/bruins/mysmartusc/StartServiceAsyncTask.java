package com.example.bruins.mysmartusc;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.Folder;
import javax.mail.Store;

public class StartServiceAsyncTask extends AsyncTask<Void, Void, Void> {
    private Context currContext;
    public StartServiceAsyncTask(Context currContext) {
        this.currContext = currContext;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
    @Override
    protected Void doInBackground(Void... params) {
        NotificationUtils mNotificationUtils = new NotificationUtils(currContext);
        NotificationSender mySender = new NotificationSender(mNotificationUtils);
        Store store = Globals.getInstance().getStore();
        try {
            IMAPFolder emailFolder = (IMAPFolder) store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);
            ServiceClass service = new ServiceClass(emailFolder, mySender);
            Globals.getInstance().setService(service);
            service.onStartCommand(null, 0, 1);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
