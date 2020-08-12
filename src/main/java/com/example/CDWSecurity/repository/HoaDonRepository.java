package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HoaDonRepository extends JpaRepository<HoaDon,Long> {
    @Query(value = "SELECT max(id) FROM HoaDon ")
    Long findMaxId();
}
