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
public class ConsumerCreationDTO extends UserCreationDTO {
    private String shippingAddress;
    private String paymentMethod;
    
    // Getter and setter for shippingAddress
    public String getShippingAddress() {
        return shippingAddress;
    }
    
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    // Getter and setter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    

}
