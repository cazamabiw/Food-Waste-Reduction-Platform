/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.businesslayer;

import com.fwrp.datatier.dao.RetailerDao;
import com.fwrp.datatier.dao.RetailerDaoImpl;
import com.fwrp.datatier.dao.RoleDao;
import com.fwrp.datatier.dao.RoleDaolmpl;
import com.fwrp.datatier.dao.UserDao;
import com.fwrp.datatier.dao.UserDaoImpl;
import com.fwrp.datatier.dao.UserRoleDao;
import com.fwrp.datatier.dao.UserRoleDaoImpl;
import com.fwrp.models.Retailer;
import com.fwrp.models.Role;
import com.fwrp.models.User;
import com.fwrp.models.UserRole;
import com.fwrp.utilities.UserRoleResult;

/**
 *
 * @author Jessica Gunawan
 */
public class RoleManager {
 
    private RoleDao roleDAO;
    private UserRoleDao userRoleDAO;

    public RoleManager() {

     
        roleDAO = new RoleDaolmpl();
        userRoleDAO = new UserRoleDaoImpl();

    }

    
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }
  public Role getRoleById(int roleId){
    return  roleDAO.get(roleId);
  }
    public void createUserRole(UserRole userRole) {
        userRoleDAO.insert(userRole);
    }

  public UserRole getRoleByUserId(int userId){
    return  userRoleDAO.getRoleByUserId(userId);
  }
  
public UserRoleResult getUserRoleName(int userId) {
    UserRole userRole = getRoleByUserId(userId);
    if (userRole == null) {
        // Handle case where UserRole is not found
        return null; // or throw an exception, or return a default value
    }
    
    Role role = getRoleById(userRole.getRoleId());
    if (role == null) {
        // Handle case where Role is not found
        return null; // or throw an exception, or return a default value
    }
    
    String roleName = role.getRoleName();
    UserRoleResult result = new UserRoleResult(userRole.getUserId(), userRole.getRoleId(), roleName);
    return result;
}


}
