/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojo.Cart;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author QUOC ANH
 */
@Controller
public class CartController {
    

            @GetMapping("/cart")
    public String cart(Model model, HttpSession session) 
    {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        
        return "cart";
    
    }
}
