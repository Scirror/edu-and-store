/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmall.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zxa
 */

@Repository
public class BaseDaoImpl<T> implements BaseDao {

    //获取泛型类型
    private Class<T> subclass;
    
    
    @Autowired
    protected HibernateTemplate hibernateTemplate;
    
    
    

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

   
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public BaseDaoImpl() {
    }
    
    
    
    
    public BaseDaoImpl(Class<T> subclass ) {
        this.subclass = subclass;
    }
    
    
    //查询所有
    @Override
    public List<T> findAll() throws Exception {
        String hql = "from "+subclass.getSimpleName();
 
        return (List<T>)hibernateTemplate.find(hql);
    }

    
    //根据主键查询（主键为整形）
    @Override
    public T findByIntPK(Integer primaryKey) throws Exception {
        return hibernateTemplate.get(subclass, primaryKey);
        
    }

    
    //删除对象需要先查询
    @Override
    public void delete(Object object) throws Exception {
        hibernateTemplate.delete(object);
    }

    //增加对象
    @Override
    public void save(Object object) throws Exception {
        hibernateTemplate.save(object);
    }

    
    //更新对象需先查询
    @Override
    public void update(Object object) throws Exception {
        hibernateTemplate.update(object);
    }

    
    //保存或者更新
    @Override
    public void updateOrSave(Object object ) throws Exception {
        hibernateTemplate.saveOrUpdate(object);
    }


    
}
