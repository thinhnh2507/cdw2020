package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
    @Query(value = "SELECT max(id) FROM SanPham ")
    Long findMaxId();
    @Query(value = "SELECT tensanpham FROM SanPham where tensanpham like %:key%")
    List<String> searchKey(@Param("key") String keysearch);
}
