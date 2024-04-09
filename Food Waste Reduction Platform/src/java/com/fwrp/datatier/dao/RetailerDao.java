/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.Dao;
import com.fwrp.models.Retailer;

/**
 *
 * @author Sreelakshmi odatt Venu
 */
public interface RetailerDao extends Dao<Retailer> {
           Retailer getRetailerByUserId(int userId);
}
