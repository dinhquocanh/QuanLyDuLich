/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Loaihinhdulich;
import com.mycompany.repository.LoaihinhdulichRepository;
import java.util.List;
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
public class LoaihinhdulichRepositoryImpl implements LoaihinhdulichRepository
{
      @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
   @Override
   public List<Loaihinhdulich> getLoaihinhdulich()
   {
       Session seesion = this.sessionFactory.getObject().getCurrentSession();
       Query q=seesion.createQuery("FROM Loaihinhdulich");
       
       return q.getResultList();
   }
}
