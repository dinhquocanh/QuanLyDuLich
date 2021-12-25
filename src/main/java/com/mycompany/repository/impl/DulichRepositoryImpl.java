/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Dulich;
import com.mycompany.repository.DulichRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class DulichRepositoryImpl implements DulichRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Dulich> getDulich(String kw) 
    
    {
        
      Session session=this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Dulich> query=builder.createQuery(Dulich.class);
        Root root= query.from(Dulich.class);
        query=query.select(root);
        
        
        if(kw!=null && !kw.isEmpty())
        {
            Predicate pre=builder.like(root.get("tendulich").as(String.class),String.format("%%%s%%", kw));
            query=query.where(pre);
        }
        
        query=query.orderBy(builder.desc(root.get("id")));
        
        Query q=session.createQuery(query);
        return  q.getResultList();
    }

    @Override
    public List<Dulich> getDulich(Integer loaihinhdulichId) {
        Session session=this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Dulich> query=builder.createQuery(Dulich.class);
        Root root= query.from(Dulich.class);
        query=query.select(root);
        
        
      query=query.where(builder.equal(root.get("loaihinhdulichId"), loaihinhdulichId));
           
       
        
        query=query.orderBy(builder.desc(root.get("id")));
        
        Query q=session.createQuery(query);
        return  q.getResultList();

    }

    @Override
    public boolean addorUpdate(Dulich d) 
    {
        Session session=sessionFactory.getObject().getCurrentSession();
        try
        {
            session.save(d);
            
            return true;
        }catch (HibernateException ex)
        {
            ex.printStackTrace();
        }
        
        return false;
      }
    
}
