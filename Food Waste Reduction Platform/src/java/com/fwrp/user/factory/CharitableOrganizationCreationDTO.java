/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.factory;

import com.fwrp.datatier.dto.UserCreationDTO;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class CharitableOrganizationCreationDTO extends UserCreationDTO {
    private String organizationName;
    
    // Getter and setter for organizationName
    public String getOrganizationName() {
        return organizationName;
    }
    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    
    // Other methods...
}