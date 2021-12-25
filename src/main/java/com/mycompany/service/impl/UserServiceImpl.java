/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Nhanvien;
import com.mycompany.repository.UserRepository;

import com.mycompany.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author QUOC ANH
 */

@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
   
     @Autowired
    private Cloudinary cloudinary;

    @Override
    public Nhanvien getUserByUsername(String username)
    {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean addUser(Nhanvien user) 
    {
        user.setMatkhau(passwordEncoder.encode(user.getMatkhau()));
        if (user.getFile()!= null) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setAnhdaidien(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.userRepository.addUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        Nhanvien user = this.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username!!!");
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getQuyen()));
        
        return new org.springframework.security.core.userdetails.User(
                user.getTaikhoan(), user.getMatkhau(), authorities);    }
    
}
