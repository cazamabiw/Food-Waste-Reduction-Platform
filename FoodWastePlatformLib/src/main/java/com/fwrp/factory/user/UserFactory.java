/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.factory.user;

import java.util.Map;

import com.fwrp.models.User;


/**
 *
 * @author cazam
 */
public abstract class  UserFactory {
   
   public static User createUser(String userType, User user, Map<String, String> additionalParams) {
//        switch (userType.toLowerCase()) {
//            case RETAILER:
////                return new Truck("Ford F-150","V6 Turbocharged","XL","Blue");
//                  return new RetilerFactory(user,additionalParams);
//            case CONSUMER:
//                return new ConsumerUserFactory(user,additionalParams);
//               case CHARITABLE_ORGANIZATION:
////                return new MotorBike("BMW S1000RR","Inline-4","Superbike","Green");
//            default:
//                throw new IllegalArgumentException("Invalid vehicle type: " + userType);
//        }
return null;
   }
}

