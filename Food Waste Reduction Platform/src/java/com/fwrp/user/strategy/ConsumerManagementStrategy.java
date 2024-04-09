/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.strategy;

import com.fwrp.datatier.businesslayer.RoleManager;
import com.fwrp.datatier.businesslayer.UserManager;
import com.fwrp.datatier.businesslayer.UserSettingManager;
import com.fwrp.datatier.dto.CurrentConsumerDTO;
import com.fwrp.datatier.dto.CurrentUserDTO;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.models.Consumer;
import com.fwrp.models.Role;
import com.fwrp.models.User;
import com.fwrp.models.UserNotificationSetting;

import com.fwrp.models.UserRole;
import com.fwrp.user.builder.ConsumerBuilder;
import com.fwrp.user.factory.ConsumerCreationDTO;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.LoginResult;
import com.fwrp.utilities.PasswordService;

/**
 *
 * @author  Sreelakshmi Odatt Venu
 */
public class ConsumerManagementStrategy implements UserManagementStrategy {

    private ConsumerCreationDTO consumerCreationDTO;
    private CurrentConsumerDTO currentConsumerDTO;
    private final UserSettingManager userSettingManager;
    private final UserManager userManager;
    private final RoleManager roleManager;

    public ConsumerManagementStrategy(UserManager userManager, RoleManager roleManager, UserSettingManager userSettingManager) {
        this.userManager = userManager;
        this.roleManager = roleManager;
        this.userSettingManager = userSettingManager;
    }

    @Override
    public void createUser(UserCreationDTO userCreatation) {

        consumerCreationDTO = (ConsumerCreationDTO) userCreatation;
        // Check if the email is already in use
        if (userManager.isEmailInUse(consumerCreationDTO.getEmail())) {
            return;
        }
        Consumer user = new ConsumerBuilder()
                .withFirstName(consumerCreationDTO.getFirstName())
                .withLastName(consumerCreationDTO.getLastName())
                .withEmail(consumerCreationDTO.getEmail())
                .withPassword(consumerCreationDTO.getPassword())
                .withAddressLine(consumerCreationDTO.getAddressLine())
                .withCity(consumerCreationDTO.getCity())
                .withProvince(consumerCreationDTO.getProvince())
                .withPostalCode(consumerCreationDTO.getPostalCode())
                .withLastUpdated()
                   .withPhoneNumber(consumerCreationDTO.getPhoneNumber())
                .build();

        // Create the user in the database
        userManager.createUser(user);

        // Retrieve the created user to get the user ID
        User currentUser = userManager.getUserByEmail(consumerCreationDTO.getEmail());
        if (currentUser != null) {
            // Assign user role
            UserRole userRole = new UserRole();
            Role role = roleManager.getRoleByName(consumerCreationDTO.getRoleName().getLabel());
            if (role != null) {
                userRole.setRoleId(role.getRoleId());
                userRole.setUserId(currentUser.getUserId());
                roleManager.createUserRole(userRole);
            }

            // Set additional properties specific to Retailer user
            user.setUserId(currentUser.getUserId());
            user.setPaymentMethod(consumerCreationDTO.getPaymentMethod());
            user.setShippingAddress(consumerCreationDTO.getShippingAddress());
            userManager.createConsumerDetail(user);
            
            //create UserNotificationSetting
            UserNotificationSetting userNotificationSetting = new UserNotificationSetting(user.getUserId(),false,false); //default false
             userSettingManager.createUserNotificationSetting(userNotificationSetting);
        }
    }

    @Override
    public void updateUserProfile(CurrentUserDTO currentUser) {
        // Fetch existing user details
        try {
            currentConsumerDTO = (CurrentConsumerDTO) currentUser;
            //   currentRetailerDTO = (CurrentRetailerDTO) currentUser;
            User existingUser = userManager.getUserById(currentConsumerDTO.getUserId());
            if (existingUser == null) {
                System.out.println("User not found");
                return; //must return or throw
                //return exeption
            }

            // If the email has been updated, check if it's already in use
            if (!currentConsumerDTO.getEmail().equals(existingUser.getEmail()) && userManager.isEmailInUse(currentConsumerDTO.getEmail())) {
                System.out.println("Email is already in use");
                return;
                //return exeption
            }
            Consumer user = new ConsumerBuilder()
                    .withUserId(currentConsumerDTO.getUserId())
                    .withFirstName(currentConsumerDTO.getFirstName())
                    .withLastName(currentConsumerDTO.getLastName())
                    .withEmail(currentConsumerDTO.getEmail())
                    .withPassword(currentConsumerDTO.getPassword())
                    .withAddressLine(currentConsumerDTO.getAddressLine())
                    .withCity(currentConsumerDTO.getCity())
                    .withProvince(currentConsumerDTO.getProvince())
                    .withPostalCode(currentConsumerDTO.getPostalCode())
                    .withLastUpdated()
                        .withPhoneNumber(currentConsumerDTO.getPhoneNumber())
                    .withPaymentMethod(currentConsumerDTO.getPaymentMethod())
                    .withShippingAddress(currentConsumerDTO.getShippingAddress())
                    .build();
            userManager.updateUser(user);

            userManager.updateConsumerDetail(user);

            System.out.println("User profile updated successfully");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public Consumer getCurrentUser(int userId) {
        User currentUser = userManager.getUserById(userId);
        if (currentUser == null) {
            System.out.println("User not found");
            return null;
            //return exeption
        }
        Consumer user = new ConsumerBuilder()
                .withFirstName(currentUser.getFirstName())
                .withLastName(currentUser.getLastName())
                .withEmail(currentUser.getEmail())
                //   .withPassword(currentUser.getPassword())
                .withAddressLine(currentUser.getAddressLine())
                .withCity(currentUser.getCity())
                .withProvince(currentUser.getProvince())
                .withPostalCode(currentUser.getPostalCode())
                 .withPhoneNumber(currentUser.getPhoneNumber())
                .withLastUpdated()
                .build();
        // Fetch additional details for the consumer
        Consumer consumerDetail = userManager.getConsumerByUserId(currentUser.getUserId());

        if (consumerDetail != null) {
            // Set additional details to the current user
            user.setPaymentMethod(consumerDetail.getPaymentMethod());
            user.setShippingAddress(consumerDetail.getShippingAddress());
        } else {
            // Handle case where additional details are not found
            System.out.println("Additional details not found for user with userId: " + currentUser.getUserId());
        }

        // Return the retrieved user
        return user;
    }}