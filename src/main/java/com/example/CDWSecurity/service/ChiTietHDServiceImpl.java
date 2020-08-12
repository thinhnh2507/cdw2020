package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.ChiTietHoaDon;
import com.example.CDWSecurity.repository.ChiTietHDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ChiTietHDServiceImpl implements ChiTietHdService{
    @Autowired
    ChiTietHDRepository chiTietHDRepository;
    @Override
    public ChiTietHoaDon create(ChiTietHoaDon chiTietHoaDon) {
        return chiTietHDRepository.save(chiTietHoaDon);
    }
}
