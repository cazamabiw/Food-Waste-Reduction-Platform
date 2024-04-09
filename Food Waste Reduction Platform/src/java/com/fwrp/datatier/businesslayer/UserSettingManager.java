package com.fwrp.datatier.businesslayer;

import com.fwrp.datatier.dao.FoodItemDao;
import com.fwrp.datatier.dao.FoodItemDaoImpl;
import com.fwrp.datatier.dao.UserFoodPreferenceDao;
import com.fwrp.datatier.dao.UserFoodPreferenceDaolmpl;
import com.fwrp.datatier.dao.UserNotificationSettingDao;
import com.fwrp.datatier.dao.UserNotificationSettingDaolmpl;
import com.fwrp.datatier.dto.UserFoodPreferenceDTO;
import com.fwrp.models.FoodItem;
import com.fwrp.models.UserFoodPreference;
import com.fwrp.models.UserNotificationSetting;
import java.util.ArrayList;
import java.util.List;

public class UserSettingManager {
    
    //eveything about usersetting
    //setfoodPreference

    private final UserNotificationSettingDao userNotificationSettingDao;
    private final UserFoodPreferenceDao userFoodPreferenceDao;
    private final FoodItemDao foodItemDao;

    public UserSettingManager() {

        userNotificationSettingDao = new UserFoodPreferenceDaolmpl();
        userFoodPreferenceDao = new UserFoodPreferenceDaolmpl();
        foodItemDao = new FoodItemDaoImpl();
    }

    public void createUserNotificationSetting(UserNotificationSetting userNotificationSetting) {
        userNotificationSettingDao.insert(userNotificationSetting);
    }

    public UserNotificationSetting getUserNotificationSetting(int userId) {
        return userNotificationSettingDao.get(userId);
    }

    public void updateUserNotificationSetting(UserNotificationSetting userNotificationSetting) {
        userNotificationSettingDao.update(userNotificationSetting);
    }

    public void addUserFoodPreference(UserFoodPreference userFoodPreference) {

        userFoodPreferenceDao.insert(userFoodPreference);
    }

    public void updateUserFoodPreference(UserFoodPreference userFoodPreference) {
        userFoodPreferenceDao.update(userFoodPreference);
    }

    public void deleteUserFoodPreference(UserFoodPreference userFoodPreference) {
        userFoodPreferenceDao.delete(userFoodPreference);
    }

    public List<UserFoodPreferenceDTO> getUserFoodPreferenceByUserId(int userId) {
        List<UserFoodPreferenceDTO> userFoodPreferenceList = new ArrayList<>();

        // Retrieve user food preferences for the given user ID from the database
        List<UserFoodPreference> userFoodPreferences = userFoodPreferenceDao.getByUserId(userId);

        // Map the food item IDs to their corresponding food names
        for (UserFoodPreference userFoodPreference : userFoodPreferences) {
            String foodName = getFoodNameById(userFoodPreference.getFoodItemId());
            userFoodPreferenceList.add(new UserFoodPreferenceDTO(userId, userFoodPreference.getFoodItemId(), foodName));
        }

        return userFoodPreferenceList;
    }

    private String getFoodNameById(int foodItemId) {
        FoodItem foodItem = foodItemDao.get(foodItemId);
        return foodItem != null ? foodItem.getItemName() : null;
    }

}
