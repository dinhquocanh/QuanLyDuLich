/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojo.Nhanvien;

/**
 *
 * @author QUOC ANH
 */
public interface UserRepository {
     Nhanvien getUserByUsername(String username);
    boolean addUser(Nhanvien user);
}
