package com.example.CDWSecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "danhmuc",schema = "cdw")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_danhmuc ;
    @Column(name = "tendanhmuc",nullable = false)
    private String tendanhmuc;
    @Column(name = "motadanhmuc",nullable = false)
    private String motadanhmuc;


    public Long getId() {
        return id_danhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getMotadanhmuc() {
        return motadanhmuc;
    }

    public void setMotadanhmuc(String motadanhmuc) {
        this.motadanhmuc = motadanhmuc;
    }
//    @JsonIgnore
//    @OneToMany(mappedBy = "danhMuc",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
//    private List<SanPham> sanPhams;
//
//    public List<SanPham> getSanPhams() {
//        return sanPhams;
//    }
//
//    public void setSanPhams(List<SanPham> sanPhams) {
//        this.sanPhams = sanPhams;
//    }
    @JsonIgnore
    @OneToMany(mappedBy = "danhMuc",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<ThuongHieu> thuongHieus;

    public List<ThuongHieu> getThuongHieus() {
        return thuongHieus;
    }

    public void setThuongHieus(List<ThuongHieu> thuongHieus) {
        this.thuongHieus = thuongHieus;
    }
}
