/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import java.util.List;

/**
 *
 * @author talle
 * @param <T>
 */
public interface IDAO<T> {
    
    List<T> findAll();
    
    T findById(Long id);
    
    void update(T t);
    
    void remove(Long id);
    
    void insert(T t);
    
}
