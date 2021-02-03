package Test_App.notifications;

import java.util.LinkedList;

public class NotificationManager implements NotificationListener {

    private LinkedList<String> notifications = new LinkedList<>();

    @Override
    public void notificationReceived(String text) {
        notifications.add(text);
    }

    public String getLastNotification() {
        return notifications.getLast();
    }
}
