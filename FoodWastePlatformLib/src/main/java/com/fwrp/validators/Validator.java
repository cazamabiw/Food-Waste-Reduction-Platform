/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.validators;

/**
 *
 * @author cazam
 * @param <T>
 */
public interface Validator<T> {
    void validate(T data);
}
