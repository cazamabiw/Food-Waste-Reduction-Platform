/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.util.List;

import com.fwrp.models.Inventory;

/**
 *
 * @author cazam
 */
public interface InventoryDao extends Dao<Inventory>{
       List<Inventory> getByUserId(int userId);
}
