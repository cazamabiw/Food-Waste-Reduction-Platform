/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.dto.Inventory;
import java.util.List;

/**
 *
 * @author cazam
 */
public interface InventoryDao extends Dao<Inventory>{
       List<Inventory> getByUserId(int userId);
}
