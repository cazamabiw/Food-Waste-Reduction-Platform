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
public class RetailerCreationDTO extends UserCreationDTO {
    private String storeName;
    private String contactPerson;
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}