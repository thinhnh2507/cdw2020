package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.HoaDon;

import java.util.List;

public interface HoaDonService {
    HoaDon create(HoaDon hoaDon);
    long maxId();
    List<HoaDon> getAll();
    HoaDon findById(long id);
}
