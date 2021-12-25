/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojo.Nhanvien;
import com.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author QUOC ANH
 */
@Controller
public class UserController 
{
       @Autowired
    private UserService userDetailsService;
       
       
      @GetMapping("/login")
    public String login()
    {
        return "login";
    }
  @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());
        
        return "register";
    }
    
    @PostMapping("/register")
    public String addUser(Model model, @ModelAttribute(value = "nhanvien") Nhanvien user) {
        
          
        String errMsg = "";
        
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+user.getMatkhau());
        if (user.getMatkhau().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUser(user))
                return "redirect:/login";
            else
                errMsg = "Hệ thống đang có lỗi, vui lòng quay lại sau !!!!";
        } else
            errMsg = "Mật khẩu không khớp";
        
        
        model.addAttribute("errMsg", errMsg);
        return "register";
    }
}
