/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formatter;

import com.mycompany.pojo.Dulich;
import com.mycompany.pojo.Loaihinhdulich;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author QUOC ANH
 */
public class LoaihinhdulichFormatter implements Formatter<Loaihinhdulich>
{

    

    @Override
    public String print(Loaihinhdulich loaihinhdulich, Locale locale) 
    {
        return String.valueOf(loaihinhdulich.getId());
    }

    @Override
    public Loaihinhdulich parse(String loaihinhdulichid, Locale locale) throws ParseException 
    {
        
            Loaihinhdulich d= new Loaihinhdulich();
            d.setId(Integer.parseInt(loaihinhdulichid));
            return d;
        
    }
    
}
