package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.HoaDon;
import com.example.CDWSecurity.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Override
    public HoaDon create(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public long maxId() {
        return hoaDonRepository.findMaxId();
    }

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon findById(long id) {
        return hoaDonRepository.findById(id).get();
    }
}
