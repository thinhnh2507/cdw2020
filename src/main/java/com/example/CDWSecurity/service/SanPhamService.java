package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.SanPham;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SanPhamService {
    List<SanPham> findAll();
    SanPham findById(long id);
    ResponseEntity<SanPham> insertSp(@RequestBody SanPham sp);
    void delete(SanPham sp);
    List<SanPham> listSanPhamByDanhMuc(long id_danhmuc);
    public Long maxId();
    List<String> searchKey(String keysearch);
}
