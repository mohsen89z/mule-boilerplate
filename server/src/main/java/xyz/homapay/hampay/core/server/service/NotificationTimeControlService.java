package xyz.homapay.hampay.core.server.service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sima on 9/21/15.
 * sima.ahmadvand@gmail.com
 */
public class NotificationTimeControlService {

    private AtomicLong notificationWaitTime = new AtomicLong(0);

    public void checkNotificationStatus() throws InterruptedException {
        if (notificationWaitTime.get() > 0)
            Thread.sleep(notificationWaitTime.get());
    }

    public void addNotificationWaitTime() {
        notificationWaitTime.addAndGet(30000);
    }

    public void resetNotificationWaitTime() {
        notificationWaitTime.set(0);
    }
}
