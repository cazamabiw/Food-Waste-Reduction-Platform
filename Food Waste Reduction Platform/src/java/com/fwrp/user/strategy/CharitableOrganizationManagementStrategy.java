/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.strategy;


import com.fwrp.datatier.businesslayer.RoleManager;
import com.fwrp.datatier.businesslayer.UserManager;
import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.datatier.dto.CurrentCharitableOrganizationDTO;
import com.fwrp.datatier.dto.CurrentConsumerDTO;
import com.fwrp.datatier.dto.CurrentUserDTO;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.models.CharitableOrganization;
import com.fwrp.models.Consumer;
import com.fwrp.models.Role;
import com.fwrp.models.User;
import com.fwrp.models.UserNotificationSetting;

import com.fwrp.models.UserRole;
import com.fwrp.user.builder.CharitableOrganizationBuilder;
import com.fwrp.user.builder.ConsumerBuilder;
import com.fwrp.user.factory.CharitableOrganizationCreationDTO;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.LoginResult;
import com.fwrp.utilities.PasswordService;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *
 * @author  Sreelakshmi Odatt Venu
 */
public class CharitableOrganizationManagementStrategy implements UserManagementStrategy {
   private final UserManager userManager;
   private final RoleManager roleManager;
       private final UserSettingManager userSettingManager;
    private CharitableOrganizationCreationDTO charitableOrganizationCreationDTO;
  private CurrentCharitableOrganizationDTO currentCharitableOrganizationDTO;
  
    public CharitableOrganizationManagementStrategy(UserManager userManager, RoleManager roleManager,UserSettingManager userSettingManager) {
        this.userManager = userManager;
        this.roleManager = roleManager;
        this.userSettingManager = userSettingManager;
    }


    @Override
    public void createUser(UserCreationDTO userCreatation) {
        charitableOrganizationCreationDTO = (CharitableOrganizationCreationDTO) userCreatation;
        // Check if the email is already in use
        if (userManager.isEmailInUse(charitableOrganizationCreationDTO.getEmail())) {
            return;
        }

     CharitableOrganization user = new CharitableOrganizationBuilder()
            .withFirstName(charitableOrganizationCreationDTO.getFirstName())
            .withLastName(charitableOrganizationCreationDTO.getLastName())
            .withEmail(charitableOrganizationCreationDTO.getEmail())
            .withPassword(charitableOrganizationCreationDTO.getPassword())
            .withAddressLine(charitableOrganizationCreationDTO.getAddressLine())
            .withCity(charitableOrganizationCreationDTO.getCity())
            .withProvince(charitableOrganizationCreationDTO.getProvince())
            .withPostalCode(charitableOrganizationCreationDTO.getPostalCode())
            .withLastUpdated()
             .withPhoneNumber(charitableOrganizationCreationDTO.getPhoneNumber())
            .build();

    // Create the user in the database
    userManager.createUser(user);

    // Retrieve the created user to get the user ID
    User currentUser = userManager.getUserByEmail(charitableOrganizationCreationDTO.getEmail());
    if (currentUser != null) {
        // Assign user role
        UserRole userRole = new UserRole();
        Role role = roleManager.getRoleByName(charitableOrganizationCreationDTO.getRoleName().getLabel());
        if (role != null) {
            userRole.setRoleId(role.getRoleId());
            userRole.setUserId(currentUser.getUserId());
            roleManager.createUserRole(userRole);
        }

        // Set additional properties specific to Retailer user
        user.setUserId(currentUser.getUserId());
        user.setOrganizationName(charitableOrganizationCreationDTO.getOrganizationName());
        userManager.createCharitableOrganizationDetail(user);
        
           //create UserNotificationSetting
            UserNotificationSetting userNotificationSetting = new UserNotificationSetting(user.getUserId(),false,false); //default false
            userSettingManager.createUserNotificationSetting(userNotificationSetting);
    }
    }

    @Override
    public void updateUserProfile(CurrentUserDTO currentUser) {
                  // Fetch existing user details
        currentCharitableOrganizationDTO = (CurrentCharitableOrganizationDTO) currentUser;
        User existingUser = userManager.getUserById(currentCharitableOrganizationDTO.getUserId());
        if (existingUser == null) {
            System.out.println("User not found");
            return;
            //return exeption
        }

        // If the email has been updated, check if it's already in use
        if (!currentCharitableOrganizationDTO.getEmail().equals(existingUser.getEmail()) && userManager.isEmailInUse(currentCharitableOrganizationDTO.getEmail())) {
            System.out.println("Email is already in use");
            return;
            //return exeption
        }

    CharitableOrganization user = new CharitableOrganizationBuilder()
                .withUserId(currentCharitableOrganizationDTO.getUserId())
                .withFirstName(currentCharitableOrganizationDTO.getFirstName())
                .withLastName(currentCharitableOrganizationDTO.getLastName())
                .withEmail(currentCharitableOrganizationDTO.getEmail())
                .withPassword(currentCharitableOrganizationDTO.getPassword())
                .withAddressLine(currentCharitableOrganizationDTO.getAddressLine())
                .withCity(currentCharitableOrganizationDTO.getCity())
                .withProvince(currentCharitableOrganizationDTO.getProvince())
                .withPostalCode(currentCharitableOrganizationDTO.getPostalCode())
                .withLastUpdated()
             .withPhoneNumber(currentCharitableOrganizationDTO.getPhoneNumber())
                .withOrganizationName(currentCharitableOrganizationDTO.getOrganizationName())
                .build();
    
        userManager.updateUser(user);   
        userManager.updateCharitableOrganizationDetail(user);

        System.out.println("User profile updated successfully");  
    }

 

   @Override
    public CharitableOrganization getCurrentUser(int userId) {
     User currentUser = userManager.getUserById(userId);
        if (currentUser == null) {
            System.out.println("User not found");
            return null;
            //return exeption
        }
        // Fetch the user from the data source using the provided userId
          CharitableOrganization user = new CharitableOrganizationBuilder()
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
        CharitableOrganization charitableOrganizationDetail = userManager.getCharitableOrganizationByUserId(currentUser.getUserId());
        
        if (charitableOrganizationDetail != null) {
            // Set additional details to the current user
            user.setOrganizationName(charitableOrganizationDetail.getOrganizationName());
       
        } else {
            // Handle case where additional details are not found
            System.out.println("Additional details not found for user with userId: " + currentUser.getUserId());
        }

        // Return the retrieved user
        return user;
    }
    
}