package com.example.bruins.mysmartusc;
import android.app.Notification;

import com.example.bruins.mysmartusc.NotificationUtils;



public class NotificationSender {

    private NotificationUtils mNotificationUtils;

    NotificationSender(NotificationUtils notificationUtils) {
        mNotificationUtils = notificationUtils;
    }

    public void SendNotification(int type, String title, String subject, String body) {
        Notification.Builder nb = mNotificationUtils.getAndroidChannelNotification(title, subject, body);
        mNotificationUtils.getManager().notify(101, nb.build());
    }

}
