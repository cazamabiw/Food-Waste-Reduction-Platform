/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.dto.User;

/**
 *
 * @author cazam
 */
public interface UserDao extends Dao<User> {
    User getByEmail(String email);
}