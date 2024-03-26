/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.dao;

import java.util.List;

public interface Dao<T> {
    
    T get(int id);
    
    List<T> getAll();
    
    void insert(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}