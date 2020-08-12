package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.HoaDon;

public interface HoaDonService {
    HoaDon create(HoaDon hoaDon);
    long maxId();
}
