/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.strategy;


import com.fwrp.datatier.businesslayer.RoleManager;
import com.fwrp.datatier.businesslayer.UserManager;
import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.utilities.UserType;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class UserManagementStrategyFactory {
        public static UserManagementStrategy createStrategy(UserType userType,UserManager userManager,RoleManager roleManager,UserSettingManager userSettingManager) {
        switch (userType) {
            case RETAILER:
               return new RetailerManagementStrategy(userManager,roleManager,userSettingManager);
            case CONSUMER:
                return new ConsumerManagementStrategy(userManager,roleManager,userSettingManager);
            case CHARITABLE_ORGANIZATION:
                return new CharitableOrganizationManagementStrategy(userManager,roleManager,userSettingManager);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}
