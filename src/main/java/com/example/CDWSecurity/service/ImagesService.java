package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.Images;

import java.util.List;

public interface ImagesService {
    void deleteImages(Images images);
    Images findById(long id);
    Images insertImages(Images images);
    void updateImages(Images images);
}
