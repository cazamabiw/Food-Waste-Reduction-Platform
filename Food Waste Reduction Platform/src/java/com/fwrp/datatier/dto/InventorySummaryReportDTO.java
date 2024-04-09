/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dto;

import java.util.Date;

/**
 *
 * @author beyul
 */
public class InventorySummaryReportDTO {
    private Date startDate;
    private Date endDate;
    private int minimizeFoodWasteTotal;
    private String foodNameCommon;
    private int foodNameCommonQuantity;
    private String foodNameUnCommon;
    private int foodNameUnCommonQuantity;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMinimizeFoodWasteTotal() {
        return minimizeFoodWasteTotal;
    }

    public void setMinimizeFoodWasteTotal(int minimizeFoodWasteTotal) {
        this.minimizeFoodWasteTotal = minimizeFoodWasteTotal;
    }

    public String getFoodNameCommon() {
        return foodNameCommon;
    }

    public void setFoodNameCommon(String foodNameCommon) {
        this.foodNameCommon = foodNameCommon;
    }

    public int getFoodNameCommonQuantity() {
        return foodNameCommonQuantity;
    }

    public void setFoodNameCommonQuantity(int foodNameCommonQuantity) {
        this.foodNameCommonQuantity = foodNameCommonQuantity;
    }

    public String getFoodNameUnCommon() {
        return foodNameUnCommon;
    }

    public void setFoodNameUnCommon(String foodNameUnCommon) {
        this.foodNameUnCommon = foodNameUnCommon;
    }

    public int getFoodNameUnCommonQuantity() {
        return foodNameUnCommonQuantity;
    }

    public void setFoodNameUnCommonQuantity(int foodNameUnCommonQuantity) {
        this.foodNameUnCommonQuantity = foodNameUnCommonQuantity;
    }
}
