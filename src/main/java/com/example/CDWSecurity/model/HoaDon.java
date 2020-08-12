package com.example.CDWSecurity.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hoadon",schema = "cdw")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;
    @Column(name = "id_user")
    private long id_user;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "sdt")
    private String sdt ;
    @Column(name = "tongtien")
    private float tongtien;
    @Column(name = "username")
    private String username;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user",insertable = false,updatable = false)
    private User HdByIdUser;
    public User getHdByIdUser() {
        return HdByIdUser;
    }
    public void setHdByIdUser(User hdByIdUser) {
        HdByIdUser = hdByIdUser;
    }

    @OneToMany(mappedBy = "chiTietHDByHD",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }
    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public HoaDon() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


