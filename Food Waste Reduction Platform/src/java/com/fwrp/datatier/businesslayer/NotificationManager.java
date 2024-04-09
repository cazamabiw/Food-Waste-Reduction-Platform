package com.fwrp.datatier.businesslayer;

import com.fwrp.models.User;
import com.fwrp.models.UserNotificationSetting;
import com.fwrp.services.notification.NotificationFactory;
import com.fwrp.services.notification.NotificationService;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationManager {
    
    private final NotificationFactory notificationFactory;
    private final UserManager userManager;
    private final UserSettingManager userSettingManager;
    private final FoodManager foodManager;
    
    public NotificationManager() {
        this.userManager = new UserManager();
         this.foodManager = new FoodManager();
         this.userSettingManager = new UserSettingManager();
        this.notificationFactory = NotificationFactory.getInstance();

    }

    public void sendNotification(String type, String recipient, String message) {
        NotificationService notification = notificationFactory.createNotification(type);
        notification.sendNotification(recipient, message);
    }
    /*
    a. User Subscription: Users can subscribe to receive surplus food alerts based on their
location, communication method (email or phone) and food preferences.
b. Automatic Notifications: Whenever retailers list surplus food items on the platform,
users subscribed to alerts receive automatic notifications via email or phone.
     */

        //get retailer Info (user) => then look at their location
        
        //get list all of user then who set notification isNotify = true then pick equal same retailer location
        //then look at userfoodpreferenceitem = fooditemid or not, if yes , look at their notificationSetting like which chanel they want 
        //to receive notification sms or email or both
       
    public void getUserSubscribeSurplusFoodAlerts(int retailerId, int foodItemId) {
        // Get retailer information (location)
        User retailer = userManager.getUserById(retailerId);
        if (retailer == null) {
            // Handle case where retailer does not exist
            System.out.println("Retailer not found.");
            return;
        }

        // Get subscribed users matching retailer's location and food preferences
        List<User> subscribedUsers = filterSubscribedUsers(retailer, foodItemId);
        
        // Send notifications to filtered users
        sendSurplusFoodAlertNotifications(subscribedUsers, foodItemId);
    }

    private List<User> filterSubscribedUsers(User retailer, int foodItemId) {
        // Get list of users who have subscribed to surplus food alerts
        List<User> subscribedUsers = userManager.getUsersSubscribedToSurplusFoodAlerts();

        // Filter users based on location and food preferences
        return subscribedUsers.stream()
                .filter(user -> user.getCity().equals(retailer.getCity()) && 
                                userSettingManager.getUserFoodPreferenceByUserId(user.getUserId()).contains(foodItemId))
                .collect(Collectors.toList());
    }

    private void sendSurplusFoodAlertNotifications(List<User> users, int foodItemId) {
        for (User user : users) {
            UserNotificationSetting userNotificationSetting = userSettingManager.getUserNotificationSetting(user.getUserId());
            String message = "Surplus food alert: " + foodManager.getFoodItem(foodItemId).getItemName();
            if (userNotificationSetting.isEmail()) {
                sendNotification("email", user.getEmail(), message);
            }
            if (userNotificationSetting.isPhone()) {
                sendNotification("sms", user.getPhoneNumber(), message);
            }
        }
    }

}
