package com.fwrp.services.notification;

public class NotificationFactory {
    private static NotificationFactory instance;

    // Private constructor to prevent instantiation from outside
    private NotificationFactory() {}

    // Method to get the singleton instance
    public static NotificationFactory getInstance() {
        if (instance == null) {
            synchronized (NotificationFactory.class) {
                if (instance == null) {
                    instance = new NotificationFactory();
                }
            }
        }
        return instance;
    }

    public NotificationService createNotification(String type) {
        if ("email".equalsIgnoreCase(type)) {
            return new EmailNotification();
        } else if ("sms".equalsIgnoreCase(type)) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Invalid notification type: " + type);
    }
}
