/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.controller;

import com.fwrp.datatier.businesslayer.FoodManager;
import com.fwrp.datatier.businesslayer.ReportManager;
import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.fwrp.datatier.dto.InventorySummaryReportDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author beyul
 */
public class ReportController {
    private final ReportManager reportManager;
    private final FoodManager foodManager;

    public ReportController() {
        // Instantiate DAO classes

        this.reportManager = new ReportManager();
        this.foodManager = new FoodManager();
    }

    public InventorySummaryReportDTO generateSummaryReport(Date startDate, Date endDate) {
        return reportManager.generateSummaryReport(startDate, endDate);
    }
  public List<InventoryHistoryDetailDTO> generateHistoryReport(Date startDate, Date endDate) {
       return reportManager.generateHistoryReport(startDate, endDate);
  }
}
