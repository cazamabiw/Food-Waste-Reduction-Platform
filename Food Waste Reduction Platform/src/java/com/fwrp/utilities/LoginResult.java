/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;

import com.fwrp.models.User;

/**
 *
 * @author Sreelakshmi Odatt Venu
 */
public class LoginResult {
     private boolean success;
    private int userId;
    private String message;

    public LoginResult(boolean success, String message,int userId) {
        this.success = success;
        this.userId = userId;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
