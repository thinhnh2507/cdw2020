package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.DanhMuc;
import com.example.CDWSecurity.model.ThuongHieu;
import com.example.CDWSecurity.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThuongHieuServiceImpl implements ThuongHieuService{
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    @Override
    public Iterable<ThuongHieu> findAllTh() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public void deleteThuongHieu(ThuongHieu thuongHieu) {
        thuongHieuRepository.delete(thuongHieu);
    }

    @Override
    public ThuongHieu findById(long id) {
        return thuongHieuRepository.findById(id).get();
    }

    @Override
    public void insertThuongHieu(ThuongHieu thuongHieu) {
    thuongHieuRepository.save(thuongHieu);
    }

    @Override
    public void updateThuongHieu(ThuongHieu thuongHieu) {

    }

    @Override
    public List<ThuongHieu> search(String s) {
        return null;
    }
}
