/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.dto.ActionLog;
import java.util.List;



/**
 *
 * @author cazam
 */
public interface ActionLogDao extends Dao<ActionLog>{
     List<ActionLog> getByUserId(int userId);
}
