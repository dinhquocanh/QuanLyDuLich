/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Dulich;
import com.mycompany.service.DulichService;
import com.mycompany.validators.DulichNameValidator;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author QUOC ANH
 */

@Controller
public class DulichController {
    
    @Autowired
    private DulichService dulichService;
    @Autowired
    private DulichNameValidator dulichNameValidator;
     
    @Autowired
    private Cloudinary cloudinary;
    
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.setValidator(dulichNameValidator);
    }
    
    
    @GetMapping("/admin/dulich")
    public String ManageDulich(Model model)
    {
        model.addAttribute("dulich",new Dulich());
        return"dulich-admin";
    }
    
    @PostMapping("/admin/dulich")
    public String  addDuLich(Model model,@ModelAttribute(value="dulich") @Valid Dulich dulich,BindingResult result)
    {
        if(result.hasErrors())
            return "dulich-admin";
        
        if(dulich.getAnhdulich()!=null)
        {
            try {
               Map res = this.cloudinary.uploader().upload(dulich.getAnhdulich().getBytes(),ObjectUtils.asMap("resource_type","auto"));
            
               dulich.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(this.dulichService.addorUpdate(dulich)==true)
            return"redirect:/";
        
        model.addAttribute("errMsg","Lỗi hệ thống !!!!");
        return"dulich-admin";
    }
}
