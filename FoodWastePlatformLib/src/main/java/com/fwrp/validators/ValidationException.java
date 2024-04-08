/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.validators;

/**
 *
 * @author cazam
 */
public class ValidationException extends Exception {

    /**
     * Constructs a new validation exception with a default message.
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a new validation exception with the specified message.
     * 
     * @param message The detail message.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new validation exception with the specified message and cause.
     * 
     * @param message The detail message.
     * @param cause The cause of the exception.
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new validation exception with the specified cause.
     * 
     * @param cause The cause of the exception.
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }
}