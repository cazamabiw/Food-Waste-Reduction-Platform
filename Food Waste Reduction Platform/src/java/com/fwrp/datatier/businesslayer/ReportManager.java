/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.businesslayer;

import com.fwrp.datatier.dao.InventoryHistoryDao;
import com.fwrp.datatier.dao.InventoryHistoryDaoImpl;
import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.fwrp.datatier.dto.InventorySummaryReportDTO;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author beyul
 */
public class ReportManager {
    private InventoryHistoryDao inventoryHistoryDao;
 private FoodManager foodManager;
    public ReportManager() {
     inventoryHistoryDao = new InventoryHistoryDaoImpl();
     this.foodManager = new  FoodManager();
    }

public InventorySummaryReportDTO generateSummaryReport(Date startDate, Date endDate) {
    // Get inventory history data for the specified date range
    List<InventoryHistoryDetailDTO> inventoryHistoryData = inventoryHistoryDao.getInventoryHistoryByDateRange(startDate, endDate);
    
    // Initialize variables to calculate summary report data
    int totalQuantity = 0;
    Map<Integer, Integer> foodItemQuantities = new HashMap<>();
    
    // Process each inventory history detail to calculate total quantity and food item quantities
    for (InventoryHistoryDetailDTO historyDetail : inventoryHistoryData) {
        totalQuantity += historyDetail.getQuantity();
        int foodItemId = historyDetail.getFoodItemId();
        int quantity = historyDetail.getQuantity();
        foodItemQuantities.put(foodItemId, foodItemQuantities.getOrDefault(foodItemId, 0) + quantity);
    }
    
    // Calculate common and uncommon food items
    String commonFoodName = null;
    int commonFoodQuantity = 0;
    String uncommonFoodName = null;
    int uncommonFoodQuantity = 0;
    for (Map.Entry<Integer, Integer> entry : foodItemQuantities.entrySet()) {
        int foodItemId = entry.getKey();
        int quantity = entry.getValue();
        if (quantity > commonFoodQuantity) {
            commonFoodName = foodManager.getFoodItem(foodItemId).getItemName(); // Implement this method to get food name by ID
            commonFoodQuantity = quantity;
        }
        if (quantity < uncommonFoodQuantity || uncommonFoodQuantity == 0) {
            uncommonFoodName = foodManager.getFoodItem(foodItemId).getItemName(); // Implement this method to get food name by ID
            uncommonFoodQuantity = quantity;
        }
    }
    
    // Create and populate the InventorySummaryReportDTO object
    InventorySummaryReportDTO summaryReport = new InventorySummaryReportDTO();
    summaryReport.setStartDate(startDate);
    summaryReport.setEndDate(endDate);
    summaryReport.setMinimizeFoodWasteTotal(totalQuantity);
    summaryReport.setFoodNameCommon(commonFoodName);
    summaryReport.setFoodNameCommonQuantity(commonFoodQuantity);
    summaryReport.setFoodNameUnCommon(uncommonFoodName);
    summaryReport.setFoodNameUnCommonQuantity(uncommonFoodQuantity);
    
    return summaryReport;
}

    public List<InventoryHistoryDetailDTO> generateHistoryReport(Date startDate, Date endDate) {
      return inventoryHistoryDao.getInventoryHistoryByDateRange(startDate, endDate);

    }
   
}
