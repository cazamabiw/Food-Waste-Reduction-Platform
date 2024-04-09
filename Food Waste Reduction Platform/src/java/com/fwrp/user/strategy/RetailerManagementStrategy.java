/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.strategy;

import com.fwrp.datatier.businesslayer.NotificationManager;
import com.fwrp.datatier.businesslayer.RoleManager;
import com.fwrp.datatier.businesslayer.UserManager;
import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.datatier.dto.CurrentRetailerDTO;
import com.fwrp.datatier.dto.CurrentUserDTO;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.models.Retailer;
import com.fwrp.models.Role;
import com.fwrp.models.User;
import com.fwrp.models.UserNotificationSetting;
import com.fwrp.models.UserRole;
import com.fwrp.user.builder.RetailerBuilder;
import com.fwrp.user.factory.RetailerCreationDTO;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.LoginResult;
import com.fwrp.utilities.PasswordService;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Date;

/**
 *
 * @author Sreelakshmi odatt Venu
 */
public class RetailerManagementStrategy implements UserManagementStrategy {

    private final UserManager userManager;
    private final RoleManager roleManager;
    private final UserSettingManager userSettingManager;
    private RetailerCreationDTO retailerCreationDTO;
    private CurrentRetailerDTO currentRetailerDTO;

    public RetailerManagementStrategy(UserManager userManager, RoleManager roleManager,UserSettingManager userSettingManager) {
        this.userManager = userManager;
        this.roleManager = roleManager;
        this.userSettingManager = userSettingManager;
    }



    @Override
    public void createUser(UserCreationDTO userCreatation) {

        retailerCreationDTO = (RetailerCreationDTO) userCreatation;
        // Check if the email is already in use
        if (userManager.isEmailInUse(retailerCreationDTO.getEmail())) {
            return;
        }

 Retailer user = new RetailerBuilder()
            .withFirstName(retailerCreationDTO.getFirstName())
            .withLastName(retailerCreationDTO.getLastName())
            .withEmail(retailerCreationDTO.getEmail())
            .withPassword(retailerCreationDTO.getPassword())
            .withAddressLine(retailerCreationDTO.getAddressLine())
            .withCity(retailerCreationDTO.getCity())
            .withProvince(retailerCreationDTO.getProvince())
            .withPostalCode(retailerCreationDTO.getPostalCode())
            .withPhoneNumber(retailerCreationDTO.getPhoneNumber())
            .withLastUpdated()
            .build();

    // Create the user in the database
    userManager.createUser(user);

    // Retrieve the created user to get the user ID
    User currentUser = userManager.getUserByEmail(retailerCreationDTO.getEmail());
    if (currentUser != null) {
        // Assign user role
        UserRole userRole = new UserRole();
        Role role = roleManager.getRoleByName(retailerCreationDTO.getRoleName().getLabel());
        if (role != null) {
            userRole.setRoleId(role.getRoleId());
            userRole.setUserId(currentUser.getUserId());
            roleManager.createUserRole(userRole);
        }

        // Set additional properties specific to Retailer user
        user.setUserId(currentUser.getUserId());
        user.setStoreName(retailerCreationDTO.getStoreName());
        user.setContactPerson(retailerCreationDTO.getContactPerson());
        userManager.createRetailerrDetail(user);
        
           //create UserNotificationSetting
           //retailers do not have notification
//            UserNotificationSetting userNotificationSetting = new UserNotificationSetting(user.getUserId(),false,false); //default false
//            notificationManager.createUserNotificationSetting(userNotificationSetting);
    }
    }

    @Override
    public void updateUserProfile(CurrentUserDTO currentUser) {
        // Fetch existing user details
        currentRetailerDTO = (CurrentRetailerDTO) currentUser;
        User existingUser = userManager.getUserById(currentRetailerDTO.getUserId());
        if (existingUser == null) {
            System.out.println("User not found");
            return;
            //return exeption
        }

        // If the email has been updated, check if it's already in use
        if (!currentRetailerDTO.getEmail().equals(existingUser.getEmail()) && userManager.isEmailInUse(currentRetailerDTO.getEmail())) {
            System.out.println("Email is already in use");
            return;
            //return exeption
        }
        // Update user profile

  
        Retailer user = new RetailerBuilder()
    .withUserId(currentRetailerDTO.getUserId())
    .withFirstName(currentRetailerDTO.getFirstName())
    .withLastName(currentRetailerDTO.getLastName())
    .withEmail(currentRetailerDTO.getEmail())
    .withPassword(currentRetailerDTO.getPassword())
    .withAddressLine(currentRetailerDTO.getAddressLine())
    .withCity(currentRetailerDTO.getCity())
    .withProvince(currentRetailerDTO.getProvince())
    .withPostalCode(currentRetailerDTO.getPostalCode())
    .withLastUpdated()
                  .withPhoneNumber(currentRetailerDTO.getPhoneNumber())
    .withStoreName(currentRetailerDTO.getStoreName())
    .withContactPerson(currentRetailerDTO.getContactPerson())
    .build();

        userManager.updateUser(user);
        userManager.updateRetailerrDetail(user);

        System.out.println("User profile updated successfully");

    }


   @Override
    public Retailer getCurrentUser(int userId) {
         User currentUser = userManager.getUserById(userId);
        if (currentUser == null) {
            System.out.println("User not found");
            return null;
            //return exeption
        }
        // Fetch the user from the data source using the provided userId
          Retailer user = new RetailerBuilder()
                .withFirstName(currentUser.getFirstName())
                .withLastName(currentUser.getLastName())
                .withEmail(currentUser.getEmail())
               // .withPassword(currentUser.getPassword())
                .withAddressLine(currentUser.getAddressLine())
                .withCity(currentUser.getCity())
                .withProvince(currentUser.getProvince())
                .withPostalCode(currentUser.getPostalCode())
                .withLastUpdated()
                   .withPhoneNumber(currentUser.getPhoneNumber())
                .build();
        // Fetch additional details for the consumer
        Retailer retailerDetail = userManager.getRetailerByUserId(currentUser.getUserId());
        
        if (retailerDetail != null) {
            // Set additional details to the current user
            user.setContactPerson(retailerDetail.getContactPerson());
            user.setStoreName(retailerDetail.getStoreName());
        } else {
            // Handle case where additional details are not found
            System.out.println("Additional details not found for user with userId: " + currentUser.getUserId());
        }

        // Return the retrieved user
        return user;
    }
}
