package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.Images;
import com.example.CDWSecurity.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService{
    @Autowired
    ImagesRepository imagesRepository;

    @Override
    public void deleteImages(Images images) {

    }

    @Override
    public Images findById(long id) {
        return imagesRepository.findById(id).get();
    }

    @Override
    public Images insertImages(Images images) {
        return imagesRepository.save(images);
    }

//    @Override
//    public ResponseEntity<Images> insertSp(Images images) {
//        try{
//            Images img = imagesRepository.save(new Images(images.getName_img(),images.getSanPham()));
//            return new ResponseEntity<>(null, HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
//        }
//    }


    @Override
    public void updateImages(Images images) {

    }
}
