/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.builder;

import com.fwrp.models.CharitableOrganization;
import com.fwrp.models.User;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.PasswordService;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class CharitableOrganizationBuilder implements UserBuilder {
    private CharitableOrganization user;

    public CharitableOrganizationBuilder() {
        this.user = new CharitableOrganization();
    }

    public CharitableOrganizationBuilder withUserId(int userId) {
        user.setUserId(userId);
        return this;
    }

    public CharitableOrganizationBuilder withFirstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public CharitableOrganizationBuilder withLastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public CharitableOrganizationBuilder withEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public CharitableOrganizationBuilder withPassword(String password) {
        user.setPassword(PasswordService.hashPassword(password));
        return this;
    }

    public CharitableOrganizationBuilder withAddressLine(String addressLine) {
        user.setAddressLine(addressLine);
        return this;
    }

    public CharitableOrganizationBuilder withCity(String city) {
        user.setCity(city);
        return this;
    }

    public CharitableOrganizationBuilder withProvince(String province) {
        user.setProvince(province);
        return this;
    }

    public CharitableOrganizationBuilder withPostalCode(String postalCode) {
        user.setPostalCode(postalCode);
        return this;
    }

    public CharitableOrganizationBuilder withLastUpdated() {
        user.setLastUpdated(DateTimeService.getCurrentUtcDateTime());
        return this;
    }

    public CharitableOrganizationBuilder withOrganizationName(String organizationName) {
        user.setOrganizationName(organizationName);
        return this;
    }

    @Override
    public CharitableOrganization build() {
        // Optionally perform any additional checks or operations before returning the user
        return user;
    }
}
