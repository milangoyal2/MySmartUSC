package com.example.bruins.mysmartusc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

public class NotificationUtils extends ContextWrapper {

    private NotificationManager mManager;
    public static final String ANDROID_CHANNEL_ID = "com.chikeandroid.tutsplustalerts.ANDROID";

    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";

    public static final String UNIMPORTANT_CHANNEL_ID = "com.chikeandroid.tutsplustalerts.UNIMPORTANT";
    public static final String UNIMPORTANT_CHANNEL_NAME = "UNIMPORTANT CHANNEL";


    public NotificationUtils(Context base) {
        super(base);
        createChannels();
    }

    public void createChannels() {

        // create android channel
        NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        androidChannel.setImportance(NotificationManager.IMPORTANCE_HIGH);

        androidChannel.setShowBadge(false);

        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(androidChannel);


        //
        NotificationChannel unimportantChannel = new NotificationChannel(UNIMPORTANT_CHANNEL_ID,
                UNIMPORTANT_CHANNEL_NAME, NotificationManager.IMPORTANCE_MIN);
        unimportantChannel.setShowBadge(true);
        unimportantChannel.setImportance(NotificationManager.IMPORTANCE_MIN);
        unimportantChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);

        getManager().createNotificationChannel(unimportantChannel);


    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public Notification.Builder getImportantChannelNotification(String title, String subject, String body) {
        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(subject)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setStyle(new Notification.BigTextStyle().bigText(body))
                .setAutoCancel(true);
    }

    public Notification.Builder getUnimportantChannelNotification(String title, String subject, String body) {
        return new Notification.Builder(getApplicationContext(), UNIMPORTANT_CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setContentTitle("You got an email with low priority")
                .setVisibility(Notification.VISIBILITY_SECRET);
    }
}
