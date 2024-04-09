/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.Inventory;
import java.util.List;

/**
 *
 * @author beyul
 */
public interface InventoryDao extends Dao <Inventory> {
    List<Inventory> getByUserId(int userId);
    List<Inventory> getIsSurplusData(int userId);  //Listing Surplus Food Items: Retailers must have the functionality to list surplus food items on the platform for donation or sale at a discounted price
    //void setIsSurplusInventory(int userId); => can use update set issurplus, discount price
    List<Inventory> getIsSurplusDataInAWeek(int userId); //Surplus items are those with expiry dates within the next one week.
    List<Inventory> getIsSurplusData(); //view for consumer and charOrg
    void updateInventoryQuantity(int id,int quantityDecrease);
}
