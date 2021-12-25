/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Dulich;
import com.mycompany.repository.DulichRepository;
import com.mycompany.service.DulichService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author QUOC ANH
 */

@Service
public class DulichServiceImpl implements DulichService

{
        @Autowired
        private DulichRepository dulichRepository;
        @Override
        public List<Dulich> getDulich(String kw) 
        {

            return this.dulichRepository.getDulich(kw);

        }

    @Override
    public List<Dulich> getDulich(Integer loaihinhdulichid) 
    {
        
        return this.dulichRepository.getDulich(loaihinhdulichid);
    }

    @Override
    public boolean addorUpdate(Dulich dulich) 
    {

            return this.dulichRepository.addorUpdate(dulich);
    }
    
}
