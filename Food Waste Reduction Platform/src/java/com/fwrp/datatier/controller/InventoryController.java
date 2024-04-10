/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.controller;

import com.fwrp.datatier.businesslayer.InventoryManager;
import com.fwrp.models.Inventory;
import com.fwrp.utilities.InventoryResult;
import java.util.List;

/**
 *
 * @author beyul
 */
public class InventoryController {
    private final InventoryManager inventoryManager;

    public InventoryController() {
        // Instantiate DAO classes

        this.inventoryManager = new InventoryManager();
    }

   //retailer
    //add, update, delete and get inventory
    public void addInventory(Inventory inventory ){
         inventoryManager.addInventory(inventory);
    }
    public void updateInventory(Inventory inventory ){
     
        inventoryManager.updateInventory(inventory);
    }
    public void deleteInventory(Inventory inventory) {
      inventoryManager.deleteInventory(inventory);
    }
    public  List<InventoryResult> getInventoryByRetailerId(int userId){
        return inventoryManager.getInventoryByRetailerId(userId);
    }
    public List<InventoryResult> getIsSurplusDataInAWeek(int userId) {
     return inventoryManager.getIsSurplusDataInAWeek(userId);
    }
    
    //consumer, charitableOrganization
    //view surplus
    public  List<InventoryResult> getSurplusInventory(String roleName){
        
        
       return inventoryManager.getSurplusInventory(roleName);
    }
    //claim  ,buy , updatequantity  and keep log 
    public void updateInventoryQuantity(int id,int quantityDecrease,String action,int actionBy){
          inventoryManager.updateInventoryQuantity(id,quantityDecrease,action,actionBy);
          //action => claim(organization), purchase(consumer) , updateStock(retailer)
          //action by => userid who take the action 
    }
}
