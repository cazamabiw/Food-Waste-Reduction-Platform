/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import com.fwrp.models.CharitableOrganization;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public interface CharitableOrganizationDao extends Dao<CharitableOrganization>{
        CharitableOrganization getCharitableOrganizationByUserId(int userId);
}
