/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.UserRole;

/**
 *
 * @author Jessica Gunawan
 */
public interface UserRoleDao extends Dao<UserRole>{
    UserRole getRoleByUserId(int userId);
}
