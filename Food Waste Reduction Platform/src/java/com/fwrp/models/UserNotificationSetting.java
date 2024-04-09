/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.models;

public class UserNotificationSetting {
    private int userId;
    private boolean isEmail;
    private boolean isPhone;

    public UserNotificationSetting(){
    }

    public UserNotificationSetting(int userId, boolean isEmail,boolean isPhone){
        this.userId = userId;
        this.isEmail = isEmail;
        this.isPhone = isPhone;
    }

    // Getters and Setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isEmail() {
        return isEmail;
    }

    public void setEmail(boolean email) {
        isEmail = email;
    }

    public boolean isPhone() {
        return isPhone;
    }

    public void setPhone(boolean phone) {
        isPhone = phone;
    }
}
