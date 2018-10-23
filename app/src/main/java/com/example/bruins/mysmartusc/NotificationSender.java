package com.example.bruins.mysmartusc;
import android.app.Notification;

import com.example.bruins.mysmartusc.NotificationUtils;



public class NotificationSender {

    private NotificationUtils mNotificationUtils;

    NotificationSender(NotificationUtils notificationUtils) {
        mNotificationUtils = notificationUtils;
    }

    public void SendNotification(int type, String title, String subject, String body) {
        if (type == 1) {
            Notification.Builder nb = mNotificationUtils.getImportantChannelNotification(title, subject, body);
            mNotificationUtils.getManager().notify(NotificationID.getID(), nb.build());
        }

        else if (type == 2) {
            Notification.Builder nb = mNotificationUtils.getUnimportantChannelNotification(title, subject, body);
            mNotificationUtils.getManager().notify(NotificationID.getID(), nb.build());
        }


    }

}
