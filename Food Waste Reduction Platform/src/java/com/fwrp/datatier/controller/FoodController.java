/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.controller;

import com.fwrp.datatier.businesslayer.FoodManager;
import com.fwrp.models.FoodItem;
import com.fwrp.models.FoodStatus;
import java.util.List;

/**
 *
 * @author beyul
 */
public class FoodController {
    private final FoodManager foodManager;

    public FoodController() {
        // Instantiate DAO classes

        this.foodManager = new FoodManager();
    }

     public List<FoodItem> getFoodItems() {
        return foodManager.getFoodItems();
    }

    public List<FoodStatus> getFoodStatuses() {
         return foodManager.getFoodStatuses();
    }
    
        public FoodItem getFoodItemByName(String foodItemName) {
             return foodManager.getFoodItemByName(foodItemName);
        }
}
