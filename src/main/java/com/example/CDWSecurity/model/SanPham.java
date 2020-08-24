package com.example.CDWSecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sanpham" ,schema = "cdw")
public class SanPham {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "tensanpham", nullable = false)
    private String tensanpham;
    @Basic
    @Column(name = "giasanpham", nullable = false)
    private float giasanpham;
    @Basic
    @Column(name = "giamgia", nullable = false)
    private float giamgia;
    @Basic
    @Column(name = "motasanpham", nullable = false)
    private String motasanpham;
    @Basic
    @Column(name = "ngaythemsanpham", nullable = false)
    private Date ngaythemsanpham;
    @Basic
    @Column(name = "soluong", nullable = false)
    private float soluong;



    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "imagesByIdSp" , fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Images> images;

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_danhmuc")
//    private DanhMuc danhMuc;
//
//    public DanhMuc getDanhMuc() {
//        return danhMuc;
//    }
//
//    public void setDanhMuc(DanhMuc danhMuc) {
//        this.danhMuc = danhMuc;
//    }
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_thuonghieu")
    private ThuongHieu thuongHieu;

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public SanPham() {
    }

    public SanPham(String tensanpham, float giasanpham, float giamgia, String motasanpham, Date ngaythemsanpham, float soluong, ThuongHieu thuongHieu) {
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.giamgia = giamgia;
        this.motasanpham = motasanpham;
        this.ngaythemsanpham = ngaythemsanpham;
        this.soluong = soluong;
        this.thuongHieu = thuongHieu;
    }

    public Long getId() {
        return id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public float getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(float giasanpham) {
        this.giasanpham = giasanpham;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }

    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        this.motasanpham = motasanpham;
    }

    public Date getNgaythemsanpham() {
        return ngaythemsanpham;
    }

    public void setNgaythemsanpham(Date ngaythemsanpham) {
        this.ngaythemsanpham = ngaythemsanpham;
    }

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }
}
