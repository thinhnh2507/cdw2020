package com.example.CDWSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "chitiethoadon",schema = "cdw")
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;
    @Column(name = "id_hoadon")
    private long id_hoadon;
    @Column(name = "id_sanpham")
    private long id_sanpham;
    @Column(name = "soluong")
    private float soluong;
    @Column(name = "giaban")
    private float giaban;

    public ChiTietHoaDon() {
    }

    @ManyToOne
    @JoinColumn(name = "id_hoadon",insertable = false,updatable = false)
    private HoaDon chiTietHDByHD;
    public HoaDon getChiTietHDByHD() {
        return chiTietHDByHD;
    }

    public void setChiTietHDByHD(HoaDon chiTietHDByHD) {
        this.chiTietHDByHD = chiTietHDByHD;
    }

    public ChiTietHoaDon(long id_hoadon, long id_sanpham, float soluong, float giaban) {
        this.id_hoadon = id_hoadon;
        this.id_sanpham = id_sanpham;
        this.soluong = soluong;
        this.giaban = giaban;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(long id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public long getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(long id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }
}

