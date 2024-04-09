/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.controller;

import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.datatier.dto.UserFoodPreferenceDTO;
import com.fwrp.models.UserFoodPreference;
import com.fwrp.models.UserNotificationSetting;
import java.util.List;

/**
 *
 * @author beyul
 */
public class UserSettingController {
    private final UserSettingManager userSettingManager;

    public UserSettingController() {
        // Instantiate DAO classes

        this.userSettingManager = new UserSettingManager();
    }

    public UserNotificationSetting getUserNotificationSetting(int userId) {

        return userSettingManager.getUserNotificationSetting(userId);
    }

    public void updateUserNotificationSetting(UserNotificationSetting userNotificationSetting) {
        userSettingManager.updateUserNotificationSetting(userNotificationSetting);
    }

    //mange food pref
    public void addUserFoodPreference(UserFoodPreference userFoodPreference) {
      userSettingManager.addUserFoodPreference(userFoodPreference);
    }

    public void updateUserFoodPreference(UserFoodPreference userFoodPreference) {
      userSettingManager.updateUserFoodPreference(userFoodPreference);
    }

    public void deleteUserFoodPreference(UserFoodPreference userFoodPreference) {
         userSettingManager.deleteUserFoodPreference(userFoodPreference);
    }

    public List<UserFoodPreferenceDTO> getUserFoodPreferenceByUserId(int userId) {
     return userSettingManager.getUserFoodPreferenceByUserId(userId);
    }
}
