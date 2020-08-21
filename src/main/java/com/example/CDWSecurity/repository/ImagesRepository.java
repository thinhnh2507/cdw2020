package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImagesRepository extends JpaRepository<Images,Long> {

}
