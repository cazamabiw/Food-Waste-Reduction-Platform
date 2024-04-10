/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;

/**
 *
 * @author sreel
 */
public class  Result {
    private boolean isSuccess;
    private String message;

    public Result(){}
    public Result(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
    
       public static Result success(String message) {
        return new Result(true, message);
    }

    public static Result failure(String message) {
        return new Result(false, message);
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}