/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Nhanvien;
import com.mycompany.repository.UserRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author QUOC ANH
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Nhanvien getUserByUsername(String username)
    {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nhanvien> query = builder.createQuery(Nhanvien.class);
        Root root = query.from(Nhanvien.class);
        query = query.select(root);
        
        query = query.where(builder.equal(root.get("taikhoan").as(String.class), username));
        
        Query q = session.createQuery(query);
        return (Nhanvien) q.getSingleResult();    }

    @Override
    public boolean addUser(Nhanvien user) 
    {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false; 
    
    
    }
    
}
