package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.SanPham;
import com.example.CDWSecurity.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SanPhamServiceImpl implements SanPhamService{

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham findById(long id) {
        return sanPhamRepository.findById(id).get();
    }


    @Override
    public ResponseEntity<SanPham> insertSp(@RequestBody SanPham sp) {
        try {
            SanPham sanPham = sanPhamRepository.save(new SanPham(sp.getTensanpham(),sp.getGiasanpham(),sp.getGiamgia(),
                    sp.getMotasanpham(),sp.getNgaythemsanpham(),sp.getSoluong(),sp.getDanhMuc()));
            return new ResponseEntity<>(sanPham, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public void delete(SanPham sp) {
        sp.setDanhMuc(null);

        sanPhamRepository.delete(sp);

    }

    @Override
    public List<SanPham> listSanPhamByDanhMuc(long id_danhmuc) {
        return null;
    }

    @Override
    public Long maxId() {
        return sanPhamRepository.findMaxId();
    }

    @Override
    public List<String> searchKey(String keysearch) {
        return sanPhamRepository.searchKey(keysearch);
    }


}
