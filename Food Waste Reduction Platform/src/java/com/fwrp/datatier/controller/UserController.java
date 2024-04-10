package com.fwrp.datatier.controller;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.fwrp.datatier.businesslayer.NotificationManager;
import com.fwrp.datatier.businesslayer.RoleManager;

import com.fwrp.datatier.businesslayer.UserManager;
import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.datatier.dto.CurrentUserDTO;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.models.User;
import com.fwrp.user.strategy.UserManagementStrategy;
import com.fwrp.user.strategy.UserManagementStrategyFactory;
import com.fwrp.utilities.LoginResult;
import com.fwrp.utilities.Result;
import com.fwrp.utilities.UserRoleResult;
import com.fwrp.utilities.UserType;

/**
 *
 * @author cazam
 */
public class UserController {
    private UserManagementStrategy strategy;
     private final UserManager userManager;
         private final RoleManager roleManager;
         private final UserSettingManager userSettingManager;
      
    public UserController() {
        // Instantiate DAO classes
        this.userManager = new UserManager();
        this.roleManager =  new RoleManager();
        this.userSettingManager =  new UserSettingManager();
    }

    public User getCurrentUser(int userId) {
    //    return strategy.getCurrentUser();
      try {
          UserRoleResult userRole = roleManager.getUserRoleName(userId);
             strategy = UserManagementStrategyFactory.createStrategy(UserType.fromLabel(userRole.getRoleName()),userManager,roleManager,userSettingManager);
           return strategy.getCurrentUser(userId);
            
          
        } catch (Exception ex) {
            return null;
        }
    }
        public UserRoleResult getRoleByUserId(int userId){
       return roleManager.getUserRoleName(userId);
    }
    public LoginResult Login(String email,String password){
      // return userManager.Login(email, password);
     return   userManager.Login(email, password);
     
    }
    
       
    public Result updateUserProfile(CurrentUserDTO user) {
         try {
             strategy = UserManagementStrategyFactory.createStrategy(user.getRoleName(),userManager,roleManager,userSettingManager);
            strategy.updateUserProfile(user);
            
            return Result.success("Update User Profile Successful!");
        } catch (Exception ex) {
            return Result.failure("Can't update user profile: " + ex.getMessage());
        }
    }

    public Result createUser(UserCreationDTO user) {
        try{
         strategy = UserManagementStrategyFactory.createStrategy(user.getRoleName(),userManager,roleManager,userSettingManager);
          strategy.createUser(user);

        return Result.success("Create User Successful!");
        }
        catch(Exception ex){
          return Result.failure("Can't create user: "+ex.getMessage());
        }
    }
    


}
