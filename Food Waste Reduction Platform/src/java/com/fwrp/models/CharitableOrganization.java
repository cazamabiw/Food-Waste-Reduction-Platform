/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.models;

import com.fwrp.models.User;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class CharitableOrganization extends User{
        // Additional properties specific to CharitableOrganization
    private String organizationName;
   

    // Getters and Setters for additional properties
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


}
