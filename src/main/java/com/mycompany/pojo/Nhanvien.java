/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author QUOC ANH
 */
@Entity
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findById", query = "SELECT n FROM Nhanvien n WHERE n.id = :id"),
    @NamedQuery(name = "Nhanvien.findByHo", query = "SELECT n FROM Nhanvien n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nhanvien.findByTen", query = "SELECT n FROM Nhanvien n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nhanvien.findByEmail", query = "SELECT n FROM Nhanvien n WHERE n.email = :email"),
    @NamedQuery(name = "Nhanvien.findByDienthoai", query = "SELECT n FROM Nhanvien n WHERE n.dienthoai = :dienthoai"),
    @NamedQuery(name = "Nhanvien.findByTaikhoan", query = "SELECT n FROM Nhanvien n WHERE n.taikhoan = :taikhoan"),
    @NamedQuery(name = "Nhanvien.findByMatkhau", query = "SELECT n FROM Nhanvien n WHERE n.matkhau = :matkhau"),
    @NamedQuery(name = "Nhanvien.findByTrangthai", query = "SELECT n FROM Nhanvien n WHERE n.trangthai = :trangthai"),
    @NamedQuery(name = "Nhanvien.findByQuyen", query = "SELECT n FROM Nhanvien n WHERE n.quyen = :quyen"),
    @NamedQuery(name = "Nhanvien.findByAnhdaidien", query = "SELECT n FROM Nhanvien n WHERE n.anhdaidien = :anhdaidien")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "dienthoai")
    private String dienthoai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "taikhoan")
    private String taikhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "matkhau")
    private String matkhau;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "quyen")
    private String quyen;
    @Size(max = 100)
    @Column(name = "anhdaidien")
    private String anhdaidien;
      @Transient
    private String confirmPassword;
    @Transient
    private MultipartFile file;
    
    {
        quyen=USER;
    }

    public Nhanvien() {
    }

    public Nhanvien(Integer id) {
        this.id = id;
    }

    public Nhanvien(Integer id, String ho, String ten, String email, String taikhoan, String matkhau) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
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
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.Nhanvien[ id=" + id + " ]";
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
