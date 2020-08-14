package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiTietHDRepository extends JpaRepository<ChiTietHoaDon,Long> {
    @Query(value = "select ct from ChiTietHoaDon ct where ct.id_hoadon = :id_hd")
    List<ChiTietHoaDon> getcthdByidHd(@Param("id_hd") long id_hd);
}
