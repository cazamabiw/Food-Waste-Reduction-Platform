/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.strategy;

import com.fwrp.datatier.dto.CurrentUserDTO;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.models.User;
import com.fwrp.utilities.LoginResult;

/**
 *
 * @author  Sreelakshmi Odatt Venu
 */
public interface UserManagementStrategy {
     User getCurrentUser(int userId);
 
    void updateUserProfile(CurrentUserDTO user);
    void createUser(UserCreationDTO user);
}
