/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.managers;

import com.fwrp.datatier.dao.UserDaoImpl;
import com.fwrp.factory.user.UserFactory;
import com.fwrp.models.User;

import java.util.Map;

/**
 *
 * @author cazam
 */
public class UserManager {
    private UserFactory userFactory; 
    private UserDaoImpl userDao; 
    
    public UserManager(){
        
    }

    public UserManager(UserFactory userFactory, UserDaoImpl userDao) {
        this.userFactory = userFactory;
        this.userDao = userDao;
    }
     public void register(String userType, String firstName, String lastName, String email, String password, Map<String, String> additionalParams) { 
//        userFactory.createUser(userType, firstName, lastName, email, password, additionalParams);
//        userDao.insert(user);
     }
     public void login(String username,String password){
     }
     public void logout(String userId){
     }
     public void updateProfile(){
     }
  }


