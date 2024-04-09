package com.fwrp.services.notification;

public class SMSNotification implements NotificationService {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Push notification SMS: "+recipient +" Message: "+message);
    }
}
