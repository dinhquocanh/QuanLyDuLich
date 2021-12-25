/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author QUOC ANH
 */
@Entity
@Table(name = "loaihinhdulich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaihinhdulich.findAll", query = "SELECT l FROM Loaihinhdulich l"),
    @NamedQuery(name = "Loaihinhdulich.findById", query = "SELECT l FROM Loaihinhdulich l WHERE l.id = :id"),
    @NamedQuery(name = "Loaihinhdulich.findByTenloaihinh", query = "SELECT l FROM Loaihinhdulich l WHERE l.tenloaihinh = :tenloaihinh"),
    @NamedQuery(name = "Loaihinhdulich.findByMota", query = "SELECT l FROM Loaihinhdulich l WHERE l.mota = :mota")})
public class Loaihinhdulich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tenloaihinh")
    private String tenloaihinh;
    @Size(max = 255)
    @Column(name = "mota")
    private String mota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaihinhdulichId")
    private Set<Dulich> dulichSet;
 
    public Loaihinhdulich() {
    }

    public Loaihinhdulich(Integer id) {
        this.id = id;
    }

    public Loaihinhdulich(Integer id, String tenloaihinh) {
        this.id = id;
        this.tenloaihinh = tenloaihinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenloaihinh() {
        return tenloaihinh;
    }

    public void setTenloaihinh(String tenloaihinh) {
        this.tenloaihinh = tenloaihinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Set<Dulich> getDulichSet() {
        return dulichSet;
    }

    public void setDulichSet(Set<Dulich> dulichSet) {
        this.dulichSet = dulichSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaihinhdulich)) {
            return false;
        }
        Loaihinhdulich other = (Loaihinhdulich) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.Loaihinhdulich[ id=" + id + " ]";
    }
    
}
