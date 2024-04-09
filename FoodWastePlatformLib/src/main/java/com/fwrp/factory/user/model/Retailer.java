/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.factory.user.model;

import com.fwrp.models.User;

/**
 *
 * @author cazam
 */
public class Retailer extends User {
    // Additional properties specific to retailers
    private String storeName;
    private String contactPerson;

    // Getters and setters for additional properties
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
    
    // You can add other methods specific to retailers here
}
