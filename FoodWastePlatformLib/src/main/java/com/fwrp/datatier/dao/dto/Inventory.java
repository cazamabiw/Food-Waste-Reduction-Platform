/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao.dto;

import java.util.Date;

public class Inventory {
    private int inventoryId;
    private int userId;
    private int foodItemId;
    private Date expirationDate;
    private int quantity;
    private double price;
    private long foodStatusId;
    private double discountedPrice;
    private boolean isSurplus;
    private Date lastUpdated;

    // Getters and Setters
    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int id) {
        this.inventoryId = inventoryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getFoodItemId() {
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

    public long getFoodStatusId() {
        return foodStatusId;
    }

    public void setFoodStatusId(long foodStatusId) {
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
}
