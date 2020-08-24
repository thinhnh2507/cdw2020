package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.DanhMuc;
import com.example.CDWSecurity.model.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {
    Iterable<ThuongHieu> findAllTh();
    void deleteThuongHieu(ThuongHieu thuongHieu);
    ThuongHieu findById(long id);
    void insertThuongHieu(ThuongHieu thuongHieu);
    void updateThuongHieu(ThuongHieu thuongHieu);
    List<ThuongHieu> search(String s);
}
