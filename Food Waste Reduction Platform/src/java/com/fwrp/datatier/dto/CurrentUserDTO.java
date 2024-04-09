/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dto;

import com.fwrp.utilities.UserType;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class CurrentUserDTO {
        private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String addressLine;
    private String city;
    private String province;
   private String phoneNumber;
    private String postalCode;
    private UserType roleName;
    
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
       this.userId = userId;
    }
     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
       public UserType getRoleName() {
        return roleName;
    }

    public void setRoleName(UserType roleName) {
        this.roleName = roleName;
    }
    
       public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
