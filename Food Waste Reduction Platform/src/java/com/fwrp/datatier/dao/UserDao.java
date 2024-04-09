/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.User;

/**
 *
 * @author Jessica Gunawan
 */
public interface UserDao extends Dao<User> {
    User getUserByEmail(String email);
   boolean isEmailInUse(String email);
}