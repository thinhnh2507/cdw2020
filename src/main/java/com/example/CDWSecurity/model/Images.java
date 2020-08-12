package com.example.CDWSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "images",schema = "cdw")
public class Images {

    private long id_img ;
    private String name_img;
    private long id_sanpham;
    private SanPham imagesByIdSp;

    @Id
    @Column(name = "id_img")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId_img() {
        return id_img;
    }

    public void setId_img(long id_img) {
        this.id_img = id_img;
    }

    @Column(name = "name_img",nullable = false)
    public String getName_img() {
        return name_img;
    }

    public void setName_img(String name_img) {
        this.name_img = name_img;
    }
    @Column(name = "id_sanpham")
    public long getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(long id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sanpham",insertable = false,updatable = false)

    public SanPham getImagesByIdSp() {
        return imagesByIdSp;
    }

    public void setImagesByIdSp(SanPham imagesByIdSp) {
        this.imagesByIdSp = imagesByIdSp;
    }

    public Images() {
    }

    public Images(String name_img, long id_sanpham) {
        this.id_img = id_img;
        this.name_img = name_img;
        this.id_sanpham = id_sanpham;
    }
}
