/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.Role;

/**
 *
 * @author Jessica Gunawan
 */
public interface RoleDao extends Dao<Role> {
       Role getRoleByName(String roleName);
}