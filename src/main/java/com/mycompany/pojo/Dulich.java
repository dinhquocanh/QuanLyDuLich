/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author QUOC ANH
 */
@Entity
@Table(name = "dulich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dulich.findAll", query = "SELECT d FROM Dulich d"),
    @NamedQuery(name = "Dulich.findById", query = "SELECT d FROM Dulich d WHERE d.id = :id"),
    @NamedQuery(name = "Dulich.findByTendulich", query = "SELECT d FROM Dulich d WHERE d.tendulich = :tendulich"),
    @NamedQuery(name = "Dulich.findByMota", query = "SELECT d FROM Dulich d WHERE d.mota = :mota"),
    @NamedQuery(name = "Dulich.findByGia", query = "SELECT d FROM Dulich d WHERE d.gia = :gia"),
    @NamedQuery(name = "Dulich.findByImage", query = "SELECT d FROM Dulich d WHERE d.image = :image"),
    @NamedQuery(name = "Dulich.findByNgaytao", query = "SELECT d FROM Dulich d WHERE d.ngaytao = :ngaytao"),
    @NamedQuery(name = "Dulich.findByTrangthai", query = "SELECT d FROM Dulich d WHERE d.trangthai = :trangthai")})
public class Dulich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 255,message = "{dulich.name.sizeError}")
    @Column(name = "tendulich")
    private String tendulich;
    @Size(max = 255)
    @Column(name = "mota")
    private String mota;
    @Column(name = "gia")
    @Min(value=10000,message="{dulich.price.minPriceError}")
    private Long gia;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @JoinColumn(name = "loaihinhdulich_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Loaihinhdulich loaihinhdulichId;
    
    @Transient
    private MultipartFile  anhdulich;

    public Dulich() {
    }

    public Dulich(Integer id) {
        this.id = id;
    }

    public Dulich(Integer id, String tendulich) {
        this.id = id;
        this.tendulich = tendulich;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTendulich() {
        return tendulich;
    }

    public void setTendulich(String tendulich) {
        this.tendulich = tendulich;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Loaihinhdulich getLoaihinhdulichId() {
        return loaihinhdulichId;
    }

    public void setLoaihinhdulichId(Loaihinhdulich loaihinhdulichId) {
        this.loaihinhdulichId = loaihinhdulichId;
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
        if (!(object instanceof Dulich)) {
            return false;
        }
        Dulich other = (Dulich) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.Dulich[ id=" + id + " ]";
    }

    /**
     * @return the anhdulich
     */
    public MultipartFile getAnhdulich() {
        return anhdulich;
    }

    /**
     * @param anhdulich the anhdulich to set
     */
    public void setAnhdulich(MultipartFile anhdulich) {
        this.anhdulich = anhdulich;
    }
    
}
