/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.builder;

import com.fwrp.models.Retailer;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.PasswordService;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class RetailerBuilder {
    private Retailer retailer;

    public RetailerBuilder() {
        this.retailer = new Retailer();
    }

    public RetailerBuilder withUserId(int userId) {
        retailer.setUserId(userId);
        return this;
    }

    public RetailerBuilder withFirstName(String firstName) {
        retailer.setFirstName(firstName);
        return this;
    }

    public RetailerBuilder withLastName(String lastName) {
        retailer.setLastName(lastName);
        return this;
    }

    public RetailerBuilder withEmail(String email) {
        retailer.setEmail(email);
        return this;
    }

    public RetailerBuilder withPassword(String password) {
        retailer.setPassword(PasswordService.hashPassword(password));
        return this;
    }

    public RetailerBuilder withAddressLine(String addressLine) {
        retailer.setAddressLine(addressLine);
        return this;
    }

    public RetailerBuilder withCity(String city) {
        retailer.setCity(city);
        return this;
    }

    public RetailerBuilder withProvince(String province) {
        retailer.setProvince(province);
        return this;
    }

    public RetailerBuilder withPostalCode(String postalCode) {
        retailer.setPostalCode(postalCode);
        return this;
    }


    public RetailerBuilder withLastUpdated() {
        retailer.setLastUpdated(DateTimeService.getCurrentUtcDateTime());
        return this;
    }
    public RetailerBuilder withStoreName(String storeName) {
        retailer.setStoreName(storeName);
        return this;
    }

    public RetailerBuilder withContactPerson(String contactPerson) {
        retailer.setContactPerson(contactPerson);
        return this;
    }
  public RetailerBuilder withPhoneNumber(String phoneNumber) {
        retailer.setPhoneNumber(phoneNumber);
        return this;
    }
  
    public Retailer build() {
        return retailer;
    }
}
