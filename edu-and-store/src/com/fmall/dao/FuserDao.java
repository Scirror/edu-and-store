/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmall.dao;

import com.fmall.pojo.Fuser;


/**
 *
 * @author zxa
 */
public interface FuserDao<T extends Fuser> extends BaseDao<Fuser> {
    
    
    T findByUserId(String id);
}
