package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
    @Query(value = "SELECT max(id) FROM SanPham ")
    Long findMaxId();

    @Query(value = "SELECT tensanpham FROM SanPham where tensanpham like %:keysearch%")
    List<String> searchKey(@Param("keysearch") String keysearch);

    @Query(value = "SELECT sp from SanPham sp where sp.tensanpham like %:key%")
    List<SanPham> searchSP(@Param("key") String key);

    @Query(value = "select sp from  SanPham  sp where sp.thuongHieu.id_thuonghieu = :id")
    List<SanPham> findByidthuonghieu(@Param("id") long id);
}
