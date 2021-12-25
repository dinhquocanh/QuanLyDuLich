/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;


import com.mycompany.pojo.Cart;
import com.mycompany.pojo.Dulich;

import com.mycompany.quanlydulich.Utils;
import com.mycompany.service.DulichService;
import com.mycompany.service.LoaihinhdulichService;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author QUOC ANH
 */

@Controller
@ControllerAdvice
public class HomeController 
{

    @Autowired
    private LoaihinhdulichService loaihinhdulichService;
    @Autowired
    private DulichService dulichService;
    
  
    
    @ModelAttribute
    public void commonAttributes(Model model,HttpSession session)
    {
             model.addAttribute("loaihinhdulich",this.loaihinhdulichService.getLoaihinhdulich());
              model.addAttribute("cartStats",Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));

    }
    
    @RequestMapping("/")
    public String index(Model model,@RequestParam(value="kw",required = false)String kw,@RequestParam(value="loaihinhdulichid",required = false)Integer loaihinhdulichid)  
    {
        if(loaihinhdulichid==null)
        {
            model.addAttribute("dulich",this.dulichService.getDulich(kw));
        }
        else
        {
             model.addAttribute("dulich",this.dulichService.getDulich(loaihinhdulichid));
        }
       
       
        return "index";
    }
    
    
    
}
