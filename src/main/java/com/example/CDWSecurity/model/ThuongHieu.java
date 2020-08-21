package com.example.CDWSecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "thuonghieu", schema = "cdw")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "tenthuonghieu")
    private String tenthuonghieu;
//    @Column(name ="id_danhmuc")
//    private Long id_danhmuc;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenthuonghieu() {
        return tenthuonghieu;
    }

    public void setTenthuonghieu(String tenthuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
    }

//    public Long getId_danhmuc() {
//        return id_danhmuc;
//    }
//
//    public void setId_danhmuc(Long id_danhmuc) {
//        this.id_danhmuc = id_danhmuc;
//    }
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_danhmuc",insertable = false,updatable = false)
    private DanhMuc danhMuc;

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
