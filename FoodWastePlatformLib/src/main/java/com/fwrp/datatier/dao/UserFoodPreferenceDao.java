/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.datatier.dao.UserFoodPreferenceDao;


import com.fwrp.models.UserFoodPreference;
import java.util.List;

public interface UserFoodPreferenceDao extends Dao<UserFoodPreference> {
    List<UserFoodPreference> getByUserId(int userId);
}
