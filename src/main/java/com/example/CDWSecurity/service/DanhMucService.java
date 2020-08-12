package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.DanhMuc;

import java.util.List;

public interface DanhMucService {
    Iterable<DanhMuc> findAllDanhMuc();
    void deleteDanhMuc(DanhMuc dmuc);
    DanhMuc findById(long id);
    void insertDanhMuc(DanhMuc dmuc);
    void updateDanhMuc(DanhMuc dmuc);
    List<DanhMuc> search(String s);
}
