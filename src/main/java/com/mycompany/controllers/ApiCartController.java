/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojo.Cart;
import com.mycompany.quanlydulich.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author QUOC ANH
 */

@RestController
@RequestMapping("/api")
public class ApiCartController {
     @PostMapping("/cart")
    public ResponseEntity<Map<String, Long>> addToCart(@RequestBody Cart cart, HttpSession session) {
        Map<Integer, Cart> myCart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (myCart == null)
            myCart = new HashMap<>();
        
        if (myCart.containsKey(cart.getId()) == true) {
            Cart c = myCart.get(cart.getId());
            c.setQuantity(c.getQuantity()+ 1);
        } else { 
            myCart.put(cart.getId(), cart);
        }
        
        session.setAttribute("cart", myCart);
        
        return new ResponseEntity<>(Utils.countCart(myCart), HttpStatus.CREATED);
}
    
    @PutMapping("/cart")
    public ResponseEntity<Map<String, Long>> updateCart(@RequestBody Cart cart, HttpSession session) {
        Map<Integer, Cart> myCart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if (myCart != null) {
            if (myCart.containsKey(cart.getId()) == true) {
                Cart c = myCart.get(cart.getId());
                c.setQuantity(cart.getQuantity());
                
                session.setAttribute("cart", myCart);
            }
                
        }
        
        return new ResponseEntity<>(Utils.countCart(myCart), HttpStatus.OK);
    }
    
      @DeleteMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(
            @PathVariable(value="productId") Integer productId,
            HttpSession session) {
        Map<Integer, Cart> myCart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if (myCart != null) {
            if (myCart.containsKey(productId) == true) {
                myCart.remove(productId);
                
                session.setAttribute("cart", myCart);
            }
        }
    }
}
