/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.businesslayer;

import com.fwrp.datatier.dao.InventoryDao;
import com.fwrp.datatier.dao.InventoryDaoImpl;
import com.fwrp.datatier.dao.InventoryHistoryDao;
import com.fwrp.models.Inventory;
import com.fwrp.models.InventoryHistory;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.InventoryResult;
import java.util.List;

/**
 *
 * @author beyul
 */
public class InventoryManager {
    private InventoryDao inventoryDao;
      private InventoryHistoryDao inventoryHistoryDao;
      private NotificationManager notificationManager;
    public InventoryManager() {

        notificationManager = new NotificationManager();
        inventoryDao = new InventoryDaoImpl();
       
    }
    
    //retailer
    //add, update, delete and get inventory
    public void addInventory(Inventory inventory ){
         inventoryDao.insert(inventory);
           logInventoryAction(inventory.getId(), inventory.getQuantity(), "Add new", inventory.getUserId());
    }
 public void updateInventory(Inventory inventory) {
    try {
        // Get the current inventory from the database before updating
        Inventory currentInventory = inventoryDao.get(inventory.getId());
        
        // Update the inventory in the database
        inventoryDao.update(inventory);
        
        // Check if quantity has changed
        int quantityChange = inventory.getQuantity() - currentInventory.getQuantity();
        if (quantityChange != 0) {
            // Log the inventory action
            logInventoryAction(inventory.getId(), quantityChange, "Quantity Change", inventory.getUserId());
        }
        
        // Check if isSurplus flag has been set to true
        if (inventory.isSurplus() && !currentInventory.isSurplus()) {
            // Log the inventory action
            logInventoryAction(inventory.getId(), 0, "Set Surplus", inventory.getUserId());
            
            //send notification to user who subscribe
            notificationManager.getUserSubscribeSurplusFoodAlerts(inventory.getUserId(), inventory.getFoodItemId());
        }
        
    } catch (Exception ex) {
        // Handle exception appropriately
        ex.printStackTrace();
    }
}

    public void deleteInventory(Inventory inventory) {
      inventoryDao.delete(inventory);
        
    }
    public  List<InventoryResult> getInventoryByRetailerId(int userId){
        return inventoryDao.getByUserId(userId);
    }
    public List<InventoryResult> getIsSurplusDataInAWeek(int userId) {
     return inventoryDao.getIsSurplusDataInAWeek(userId);
    }
    
    //consumer, charitableOrganization
    //view surplus
    public  List<InventoryResult> getSurplusInventory(){
       return inventoryDao.getIsSurplusDataWithDetail();
    }
    //claim  ,buy  and keep log 
    public void updateInventoryQuantity(int id,int quantityDecrease,String roleName,int actionBy){
          inventoryDao.updateInventoryQuantity( id, quantityDecrease);
          //action => claim(organization), purchase(consumer) , updateStock(retailer)
          //action by => userid who take the action 
          String action = "";
          if("charitable_organization".equals(roleName)){
               action = "Claim";
          }
          else if("consumer".equals(roleName))
          {  action = "Purchase";
          }
             logInventoryAction(id, quantityDecrease, action, actionBy);
    }
       private void logInventoryAction(int itemId, int quantityChange, String actionType, int userId) {
        try {
            // Get current timestamp
          
            
            // Log the action in the inventory history
            InventoryHistory inventoryLog = new InventoryHistory();
            inventoryLog.setInventoryId(userId);
            inventoryLog.setQuantity(quantityChange); //can be positive /negative number
            inventoryLog.setAction(actionType);
            inventoryLog.setDateModified(DateTimeService.getCurrentUtcDateTime());
            inventoryLog.setInventoryId(itemId);            
            inventoryHistoryDao.insert(inventoryLog);
                    
        } catch (Exception ex) {
            // Handle exception (e.g., log error, throw exception, etc.)
            ex.printStackTrace();
        }
    }
}
