/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.user.builder;

import com.fwrp.models.Consumer;
import com.fwrp.models.User;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.PasswordService;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class ConsumerBuilder {
    private Consumer consumer;

    public ConsumerBuilder() {
        this.consumer = new Consumer();
    }

    public ConsumerBuilder withUserId(int userId) {
        consumer.setUserId(userId);
        return this;
    }

    public ConsumerBuilder withFirstName(String firstName) {
        consumer.setFirstName(firstName);
        return this;
    }

    public ConsumerBuilder withLastName(String lastName) {
        consumer.setLastName(lastName);
        return this;
    }

    public ConsumerBuilder withEmail(String email) {
        consumer.setEmail(email);
        return this;
    }

    public ConsumerBuilder withPassword(String password) {
        consumer.setPassword(PasswordService.hashPassword(password));
        return this;
    }

    public ConsumerBuilder withAddressLine(String addressLine) {
        consumer.setAddressLine(addressLine);
        return this;
    }

    public ConsumerBuilder withCity(String city) {
        consumer.setCity(city);
        return this;
    }

    public ConsumerBuilder withProvince(String province) {
        consumer.setProvince(province);
        return this;
    }

    public ConsumerBuilder withPostalCode(String postalCode) {
        consumer.setPostalCode(postalCode);
        return this;
    }

     public ConsumerBuilder withLastUpdated() {
        consumer.setLastUpdated(DateTimeService.getCurrentUtcDateTime());
        return this;
    }

    public ConsumerBuilder withPaymentMethod(String paymentMethod) {
        consumer.setPaymentMethod(paymentMethod);
        return this;
    }

    public ConsumerBuilder withShippingAddress(String shippingAddress) {
        consumer.setShippingAddress(shippingAddress);
        return this;
        
    } public ConsumerBuilder withPhoneNumber(String phoneNumber) {
        consumer.setPhoneNumber(phoneNumber);
        return this;
    }

    public Consumer build() {
        return consumer;
    }
}
