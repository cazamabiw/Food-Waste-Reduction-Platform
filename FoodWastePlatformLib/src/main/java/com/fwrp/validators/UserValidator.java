/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.validators;

import com.fwrp.datatier.dao.dto.User;
import com.fwrp.factory.user.model.CharitableOrganization;
import com.fwrp.factory.user.model.Consumer;
import com.fwrp.factory.user.model.Retailer;

/**
 *
 * @author cazam
 */
public class UserValidator implements Validator<User> {

    @Override
    public void validate(User data) {
        // Implement validation logic here
    }

    public void charitableOrganizationValidate(CharitableOrganization data) {
        // Implement validation logic here
    }

    public void consumerValidate(Consumer data) {
        // Implement validation logic here
    }

    public void retailerValidate(Retailer data) {
        // Implement validation logic here
    }
}
