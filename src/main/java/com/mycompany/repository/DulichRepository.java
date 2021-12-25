/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojo.Dulich;
import java.util.List;

/**
 *
 * @author QUOC ANH
 */
public interface DulichRepository {
    List<Dulich> getDulich(String kw);
    List<Dulich> getDulich(Integer loaihinhdulichId);
    boolean addorUpdate(Dulich d);
}
