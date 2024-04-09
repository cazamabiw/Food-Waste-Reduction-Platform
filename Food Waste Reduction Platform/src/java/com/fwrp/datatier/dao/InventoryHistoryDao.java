/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.fwrp.models.InventoryHistory;
import java.util.Date;
import java.util.List;

/**
 *
 * @author beyul
 */
public interface InventoryHistoryDao extends Dao<InventoryHistory>{
    List<InventoryHistory> getByInventoryId(int inventoryId);
    List<InventoryHistoryDetailDTO> getInventoryHistoryByDateRange(Date startDate,Date endDate);
}
