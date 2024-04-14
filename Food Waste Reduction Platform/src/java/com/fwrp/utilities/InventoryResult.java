/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;

import java.util.Date;

/**
 *
 * @author cazam
 */
public class InventoryResult {

    private int id;
    private int userId;
    private int foodItemId;
    private Date expirationDate;
    private int quantity;
    private double price;
    private int foodStatusId;
    private double discountedPrice;
    private boolean isSurplus;
    private Date lastUpdated;
    
    private String foodName;
    private String firstName;
    private String lastName;
    private String foodStatus;
    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodStatusId() {
        return foodStatusId;
    }

    public void setFoodStatusId(int foodStatusId) {
        this.foodStatusId = foodStatusId;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean surplus) {
        isSurplus = surplus;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getFoodName() {
    return foodName;
}

public void setFoodName(String foodName) {
    this.foodName = foodName;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getFoodStatus() {
    return foodStatus;
}

public void setFoodStatus(String foodStatus) {
    this.foodStatus = foodStatus;
}

}


