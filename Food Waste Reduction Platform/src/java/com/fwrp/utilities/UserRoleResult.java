/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;

/**
 *
 * @author Jessica Gunawan
 */
public class UserRoleResult {
     private int userId;
    private int roleId;
    private String roleName;

    public UserRoleResult( int userId,int roleId,  String roleName) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
