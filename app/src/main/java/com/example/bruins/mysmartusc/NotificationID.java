package com.example.bruins.mysmartusc;

import java.util.concurrent.atomic.AtomicInteger;

class NotificationID {
    private static final NotificationID ourInstance = new NotificationID();

    static NotificationID getInstance() {
        return ourInstance;
    }

    private final static AtomicInteger c = new AtomicInteger(0);

    public static int getID() {
        return c.incrementAndGet();
    }

    private NotificationID() {
    }
}
