/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.util.List;

import com.fwrp.models.ActionLog;



/**
 *
 * @author cazam
 */
public interface ActionLogDao extends Dao<ActionLog>{
     List<ActionLog> getByUserId(int userId);
}
