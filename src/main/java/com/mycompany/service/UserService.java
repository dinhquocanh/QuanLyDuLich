/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojo.Nhanvien;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author QUOC ANH
 */
public interface UserService  extends UserDetailsService{
    Nhanvien getUserByUsername(String username);
    boolean addUser(Nhanvien user);
}
