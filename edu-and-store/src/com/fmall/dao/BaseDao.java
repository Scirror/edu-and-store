/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmall.dao;

import java.util.List;

/**
 *
 * @author zxa
 */
public interface BaseDao<T> {
    
    
    public List<T> findAll() throws Exception;
    
    public T findByIntPK(Integer primaryKey) throws Exception;
    
    public void delete(T object)throws Exception;
    
    public void save(T object) throws Exception ;
    
    public void update(T object) throws Exception;
    
    public void updateOrSave(T object) throws Exception;
    
}
