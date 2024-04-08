/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.algonquin.cst8288.fwrp.dto.UserRole;
import java.util.List;

/**
 *
 * @author Beulah Nwokotubo
 */
public interface UserRoleDAO {
    void addUserRole(int userId, roleId);
    void removeUserRole(int userId, roleId);
    List<UserRole> getUserRoles (int userId);
}
