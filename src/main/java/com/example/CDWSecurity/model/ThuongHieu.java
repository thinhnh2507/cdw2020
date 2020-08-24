package com.example.CDWSecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "thuonghieu", schema = "cdw")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_thuonghieu ;
    @Column(name = "tenthuonghieu")
    private String tenthuonghieu;



    public Long getId_thuonghieu() {
        return id_thuonghieu;
    }

    public void setId_thuonghieu(Long id_thuonghieu) {
        this.id_thuonghieu = id_thuonghieu;
    }

    public String getTenthuonghieu() {
        return tenthuonghieu;
    }

    public void setTenthuonghieu(String tenthuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
    }

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

    @JsonIgnore
    @OneToMany(mappedBy = "thuongHieu" ,fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<SanPham> sanPhamList;

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

}
