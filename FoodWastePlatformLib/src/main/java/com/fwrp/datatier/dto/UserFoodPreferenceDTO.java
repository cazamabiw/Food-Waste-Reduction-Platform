package com.fwrp.datatier.dto;

public class UserFoodPreferenceDTO {
    
    private int userId;
    private int foodItemId;
    private String foodName;
        public UserFoodPreferenceDTO(int userId, int foodItemId, String foodName) {
        this.userId = userId;
        this.foodItemId = foodItemId;
        this.foodName = foodName;
    }
    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

}
