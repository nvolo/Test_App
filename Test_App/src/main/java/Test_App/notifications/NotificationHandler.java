package Test_App.notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationHandler {

    private static final List<NotificationListener> listeners = new ArrayList<>();

    public static void register(NotificationListener listener) {
        listeners.add(listener);
    }

    public static void deregister(NotificationListener listener) {
        listeners.remove(listener);
    }

    public static void sendNotification(String notificationText) {
        listeners.forEach(notificationListener -> notificationListener.notificationReceived(notificationText));
    }
}
