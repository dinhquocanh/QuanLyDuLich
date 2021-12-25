/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Loaihinhdulich;
import com.mycompany.repository.LoaihinhdulichRepository;
import com.mycompany.service.LoaihinhdulichService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author QUOC ANH
 */
@Service
public class LoaihinhdulichServiceImpl implements LoaihinhdulichService
{
    @Autowired
       private LoaihinhdulichRepository loaihinhdulichRepository;

    @Override
    public List<Loaihinhdulich> getLoaihinhdulich() {
  
        return this.loaihinhdulichRepository.getLoaihinhdulich();
    }    
    
}
