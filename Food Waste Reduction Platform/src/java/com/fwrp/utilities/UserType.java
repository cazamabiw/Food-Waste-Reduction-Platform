/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;
/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public enum UserType {
     RETAILER("retailer"),
     CONSUMER("consumer"),
     CHARITABLE_ORGANIZATION("charitable_organization");   
     private final String label;
    UserType(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
        public static UserType fromLabel(String label) {
        for (UserType userType : UserType.values()) {
            if (userType.label.equalsIgnoreCase(label)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("No matching enum for label: " + label);
    }
}