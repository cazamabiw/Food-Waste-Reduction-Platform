package com.fwrp.services.notification;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
     System.out.println("Push notification Email: " + recipient + " Message: " + message);
    }
  
}
