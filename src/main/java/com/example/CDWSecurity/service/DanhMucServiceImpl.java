package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.DanhMuc;
import com.example.CDWSecurity.model.SanPham;
import com.example.CDWSecurity.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DanhMucServiceImpl implements DanhMucService{
    private List<SanPham> sanPhams;
    @Autowired
    private DanhMucRepository danhMucRepository;



    @Override
    public Iterable<DanhMuc> findAllDanhMuc() {

        return danhMucRepository.findAll();
    }

    @Override
    public void deleteDanhMuc(DanhMuc dmuc) {
//        for(SanPham i : sanPhams){
//         if(i.getDanhMuc().getId().equals(dmuc.getId())){
//             i.setDanhMuc(null);
//         }
//        }
        danhMucRepository.delete(dmuc);
    }

    @Override
    public DanhMuc findById(long id) {
        return danhMucRepository.findById(id).get();
    }


    @Override
    public void insertDanhMuc(DanhMuc dm) {
        danhMucRepository.save(dm);
    }

    @Override
    public void updateDanhMuc(DanhMuc dm) {

    }

    @Override
    public List<DanhMuc> search(String s) {
        return null;
    }

}
